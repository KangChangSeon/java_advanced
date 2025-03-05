package jdbc.callablestmt;

import lombok.Data;

import java.sql.Date;

@Data
public class User {
    int m_seq;
    String m_userid;
    String m_pwd;
    String m_email;
    String m_hp;
    Date m_registdate;
    int m_point;

    @Override
    public String toString() {
        return m_seq + " " +  m_userid + " " + m_pwd + " " + m_email + " " + m_hp + " " + m_registdate + " " + m_point;
    }
}
