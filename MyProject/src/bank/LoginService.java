package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

    public int login(String userId, String password) {
        int accountNo = -1;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "select account_no from accounts where user_id = ? and password = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                accountNo = rs.getInt("account_no");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return accountNo;
    }
}