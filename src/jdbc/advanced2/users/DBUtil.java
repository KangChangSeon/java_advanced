package jdbc.advanced2.users;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * packageName   : jdbc.advanced.users
 * fileName      : DBUtil
 * author        : a
 * date          : 2025-02-28
 * description   : 데이터베이스 연결 작업 클래스
 * =================================================
 * DATE             AUTHOR             NOTE
 * -------------------------------------------------
 * 2025-02-28        a
 */
public class DBUtil {
    @Getter
    private static DBUtil instance = new DBUtil();
    private static final String URL = "jdbc:mysql://localhost:3306/ssgdb?serverTimezone=Asia/Seoul";
    private static final String USERNAME = "ssg";
    private static final String PASSWORD = "ssg";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded ok");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private DBUtil() {}
}
