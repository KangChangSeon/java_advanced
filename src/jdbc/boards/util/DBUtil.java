package jdbc.boards.util;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    @Getter
    private static DBUtil instance = new DBUtil();
    private static final String URL = "jdbc:mysql://localhost:3306/ssgdb?serverTimezone=Asia/Seoul";
    private static final String USERNAME = "ssg";
    private static final String PASSWORD = "ssg";

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded ok");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    private DBUtil(){};

}
