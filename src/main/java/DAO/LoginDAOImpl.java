package DAO;

import Model.Login;
import Util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAOImpl implements LoginDAO {
    @Override
    public String authenticate(Login login) {
        String sql = "select * from user where email=? and password =?";

        try {
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, login.getEmail());
            stmt.setString(2, login.getPassword());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return "true";
            } else {
                return "false";

            }


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
        return "error";
    }

}
