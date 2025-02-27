package jdbc.boards.dao;

import jdbc.boards.Board;
import jdbc.boards.util.DBUtil;

import java.io.FileInputStream;
import java.sql.*;

public class BoardDAO {
    Connection connection = null;
    DBUtil db = DBUtil.getInstance();

    public void insert() {
        try {
            connection = db.getConnection();
            System.out.println("Connection ok " + connection);

            String query = "" +
                    "INSERT INTO boards (btitle, bcontent, bwriter, bdate, bfilename, bfiledata)" +
                    "VALUES(?,?,?,now(),?,?)";

            PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, "봄이로구나");
            pstmt.setString(2, "봄이 오는데 구경은 못하고 강의실에서 잡혀서 jdbc 프로그래밍을 하는 나");
            pstmt.setString(3, "kcs");
            pstmt.setString(4, "spring.jpg");
            pstmt.setBlob(5, new FileInputStream("src/jdbc/images/spring.jpg"));

            int rows = pstmt.executeUpdate();
            System.out.println(rows + "rows inserted");

            if (rows == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int bno = rs.getInt(1);
                    System.out.println("bno : " + bno);
                }
            }
            pstmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void update() {
        try {
            connection = db.getConnection();
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

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void delete() {
        try {
            connection = db.getConnection();
            System.out.println("Connection ok " + connection);

            String query = "" +
                    "DELETE FROM boards " +
                    "WHERE bno = ?";

            PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, 1);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + "rows deleted");

            pstmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void showAll() {
        try {
            connection = db.getConnection();
            System.out.println("Connection ok " + connection);

            String query = "" +
                    "SELECT * FROM boards ";

            PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBdate(rs.getDate("bdate"));
                board.setBfilename(rs.getString("bfilename"));
//                board.setBfiledata(rs.getBlob("bfiledata"));
                System.out.println(board);
            }

            pstmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void showOne() {
        try {
            connection = db.getConnection();
            System.out.println("Connection ok " + connection);

            String query = "" +
                    "SELECT * FROM boards " +
                    "WHERE bno = ?";

            PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, 1);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBdate(rs.getDate("bdate"));
                board.setBfilename(rs.getString("bfilename"));
                board.setBfiledata(rs.getBlob("bfiledata"));
                System.out.println(board);
            } else {
                System.out.println("사용자 id가 존재하지 않습니다.");
            }

            pstmt.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

