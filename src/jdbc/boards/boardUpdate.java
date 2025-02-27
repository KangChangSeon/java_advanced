package jdbc.boards;

import java.sql.*;

public class boardUpdate {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded ok " + connection);

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ssgdb?serverTimezone=Asia/Seoul", "ssg", "ssg");
            System.out.println("Connection ok " + connection);

            String query = "" +
                    "UPDATE boards SET btitle = ?" +
                    "WHERE bno = ?";

            PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, "바꾼타이틀");
            pstmt.setInt(2, 1);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + "rows updated");

            pstmt.close();

        } catch (ClassNotFoundException | SQLException e) {
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
