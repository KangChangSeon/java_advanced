package jdbc.boards;

import jdbc.boards.util.DBUtil;

import java.sql.*;

public class boardSelectOne {
    public static void main(String[] args) {
        Connection connection = null;
        DBUtil db = DBUtil.getInstance();

        try {
            connection = db.getConnection();
            System.out.println("Connection ok " + connection);

            String query = "" +
                    "SELECT * FROM boards " +
                    "WHERE bno = ?";

            PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, 1);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBdate(rs.getDate("bdate"));
                board.setBfilename(rs.getString("bfilename"));
                board.setBfiledata(rs.getBlob("bfiledata"));
                System.out.println(board);
            }else{
                System.out.println("사용자 id가 존재하지 않습니다.");
            }

            pstmt.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
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
