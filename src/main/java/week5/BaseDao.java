package week5;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao<T> {
    private Class<?> clazz;
    public BaseDao() {
        clazz = (Class) ((ParameterizedType)
                this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    /**
     * SQL 查询将查询结果直接放入ResultSet中
     *
     * @param sql    SQL语句
     * @param params 参数数组，若没有参数则为null
     * @return 结果集
     */
    private ResultSet executeQuery(String sql, Object[] params) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            // 获得连接
            Connection conn = DbUtil.getConn();
            // 调用SQL
            pst = conn.prepareStatement(sql);
            // 参数赋值
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i + 1, params[i]);
                }
            }
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    /**
     * 通用ResultSet转泛型集合
     */
    public List<T> resultSetToList(ResultSet rs) {
        List<T> list = new ArrayList<T>();
        try {
            while (rs.next()) {
                Object object = null;
                try {
                    object = clazz.getDeclaredConstructor().newInstance();
                    for (Method m : clazz.getMethods()) {
                        String methodName = m.getName();
                        //set方法
                        if (methodName.startsWith("set")) {
                            //获取字段名
                            String fieldName = methodName.substring(3);
                            //获取数据并通过反射赋值
                            m.invoke(object, rs.getObject(fieldName));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                list.add((T) object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<T> selectAll(String sql, Object[] params) {
        ResultSet resultSet = executeQuery(sql, params);
        return resultSetToList(resultSet);
    }
}
