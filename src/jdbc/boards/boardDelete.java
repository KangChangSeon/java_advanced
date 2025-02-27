package jdbc.boards;

import jdbc.boards.util.DBUtil;

import java.sql.*;

public class boardDelete {
    public static void main(String[] args) {
        Connection connection = null;
        DBUtil db = DBUtil.getInstance();

        try {
            connection = db.getConnection();
            System.out.println("Connection ok " + connection);

            String query = "" +
                    "DELETE FROM boards" +
                    "WHERE bno = ?";

            PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, 1);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + "rows deleted");

            pstmt.close();

        } catch (Exception e) {
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
