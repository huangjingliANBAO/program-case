package week5;

import org.junit.jupiter.api.Test;

import java.util.List;

public class AdminDaoTest {
    private AdminDao adminDao = new AdminDao();

    @Test
    public void selectAll() {
        System.out.println("********带参查询********");
        String sql = "SELECT * FROM t_user WHERE name = ? ";
        Object[] params = {"admin"};
        List<Admin> admins = adminDao.selectAll(sql, params);
        System.out.println(admins);
        System.out.println("********无参查询整表********");
        sql = "SELECT * FROM t_user" +
                "" +
                "" +
                "" +
                "" +
                " ";
        admins = adminDao.selectAll(sql, null);
        admins.forEach(System.out::println);
    }
}