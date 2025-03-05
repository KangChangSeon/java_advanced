package jdbc.callablestmt;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalTime.now;

public class CallableStmtEx04 {

    Connection conn = null;
    CallableStatement cs = null;

    public CallableStmtEx04() throws SQLException {
        // 1. connection 얻어오기
        conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        // 2. CallableStatement 객체를 이용하여 호출할 프로시저 연결
        cs = conn.prepareCall("{call SP_MEMBER_LIST}");
        // 3. 바인드 변수에 값을 셋팅 inprarmenter (?) 에 값 넣기

        // 4. out 파라미터에 저장된 프로시저의 수행결과에 대한 외부 변수 등록

        // 5. 쿼리 수행
        // flag의 값은 resultSet 객체의 경우는 true, 갱신 카운트 또는 결과가 없는 경우 false 리턴됨
        ResultSet rs = cs.executeQuery();
        List<User> userlist = new ArrayList<>();

        while (rs.next()) {
            User user = new User();
            user.m_seq = rs.getInt("m_seq");
            user.m_userid = rs.getString("m_userid");
            user.m_pwd = rs.getString("m_pwd");
            user.m_email = rs.getString("m_email");
            user.m_hp = rs.getString("m_hp");
            user.m_registdate = rs.getDate("m_registdate");
//            System.out.println(user);

            userlist.add(user);

//            int m_seq = rs.getInt("m_seq");
//            String m_userid = rs.getString("m_userid");
//            String m_pwd = rs.getString("m_pwd");
//            String m_email = rs.getString("m_email");
//            String m_hp = rs.getString("m_hp");
//            String m_registdate = rs.getString("m_registdate");
//
//
//            System.out.println(m_seq + " " + m_userid + " " + m_pwd + " " + m_email + " " + m_hp + " " + m_registdate);
        }

        rs.close();

        for (User u : userlist) System.out.println(u.toString());

        if (cs != null) cs.close();
        if (conn != null) conn.close();
    }

    public static void main(String[] args) throws SQLException {
        new CallableStmtEx04();
    }
}
