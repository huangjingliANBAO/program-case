package week4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description 利用反射机制调用Max类的getMax()和print()方法
 * @Author jl_huang
 * @Date 2020-01-19
 **/
public class MaxTest {
    public static void main(String[] args) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("week4.Max");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            assert  clazz!= null;
            //取得getMax方法
            Method getMaxMethod = clazz.getMethod("getMax",int.class,int.class);
            //取得print方法
            Method printMethod = clazz.getMethod("print");
            try {
                //利用反射机制调用以上方法
                getMaxMethod.invoke(clazz.getDeclaredConstructor().newInstance(),1,6);
                printMethod.invoke(clazz.getDeclaredConstructor().newInstance());
            }catch (IllegalAccessException | InvocationTargetException | InstantiationException e){
                e.printStackTrace();
            }
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }
    }
}