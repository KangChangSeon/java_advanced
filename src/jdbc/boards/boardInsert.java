package jdbc.boards;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class boardInsert {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded ok " + connection);

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ssgdb?serverTimezone=Asia/Seoul", "ssg", "ssg");
            System.out.println("Connection ok " + connection);

            String query = "" +
                    "INSERT INTO boards (btitle, bcontent, bwriter, bdate, bfilename, bfiledata)" +
                    "VALUES(?,?,?,now(),?,?)";

            PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,"봄이로구나");
            pstmt.setString(2,"봄이 오는데 구경은 못하고 강의실에서 잡혀서 jdbc 프로그래밍을 하는 나");
            pstmt.setString(3,"kcs");
            pstmt.setString(4,"spring.jpg");
            pstmt.setBlob(5, new FileInputStream("src/jdbc/images/spring.jpg"));


            int rows = pstmt.executeUpdate();
            System.out.println(rows + "rows inserted");

            // bno 값 얻어오기
            if(rows == 1){
                ResultSet rs = pstmt.getGeneratedKeys();
                if(rs.next()){
                    int bno = rs.getInt(1);
                    System.out.println("bno : " + bno);
                }
            }
            pstmt.close();

        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if(connection != null){
                try {
                    connection.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {e.printStackTrace();}
            }
        }
    }
}
