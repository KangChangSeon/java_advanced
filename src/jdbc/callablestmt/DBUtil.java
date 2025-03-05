package jdbc.callablestmt;

import java.sql.Connection;
import java.sql.SQLException;

// 싱글톤을 적용한 Connection 객체 제공
public class DBUtil {
    // 내부에서 생성해서 선택적 공유할 수 있도록 private static 선언
    private static Connection conn = null;

    // 외부에서 인스턴스 생성을 막기 위해서 private 생성자
    private DBUtil(){}

    public static Connection getConnection(){
        if(conn != null){
            return conn; // 기존에 연결이 존재한다면 그대로 반환
        }

        try {
            // 1. MySQL 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. MySQL 연결 URL (3가지 매개변수 값: URL, ID, PASSWORD)
            String url = "jdbc:mysql://localhost:3306/ssgdb?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String id = "ssg";
            String password = "ssg";
            conn = java.sql.DriverManager.getConnection(url, id, password);

            // 3. 연결성공 메세지 콘솔 출력
            System.out.println("Connection Successful");

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다 " + e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
