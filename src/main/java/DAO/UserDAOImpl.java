package DAO;

import Model.User;
import Model.Vendor;
import Util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAOImpl implements UserDAO {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<User> list = null;
    List<Vendor> vendorList = null;
    User user = null;
    Vendor vendor = null;
    PreparedStatement preparedStmt = null;

    @Override
    public List<User> get() throws SQLException {

        try {
            list = new ArrayList<User>();
            String sql = "select * from user ";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                user = new User();
                //  user.setRole(resultSet.getString("role"));
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setOtherNames(resultSet.getString("otherNames"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setAdmin(resultSet.getBoolean("isAdmin"));


                list.add(user);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return list;

    }

    @Override
    public boolean saveUser(User user) {
        boolean flag = false;
        try {


            String sql = "insert into user(firstName, otherNames, surname, email, password, isAdmin) "
                    + "values('" + user.getFirstName() + "','" + user.getOtherNames() + "','" + user.getSurname() + "','" + user.getEmail() + "','" + user.getEmail() + "','" + user.getPassword() + "'," + user.isAdmin() + ")";
            try {
                connection = DBConnectionUtil.openConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public User get(int id) {
        User user = null;
        try {
            user = new User();
            String sql = "SELECT * FROM user  WHERE id=" + id;
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setOtherNames(resultSet.getString("otherNames"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setAdmin(resultSet.getBoolean("isAdmin"));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(user.toString());
        return user;
    }

    @Override
    public boolean updateUser(User user) {

        boolean flag = false;

        try {
            String sql = "update user set firstName='" + user.getFirstName() + "', otherNames='" + user.getOtherNames() + "', surname ='" + user.getSurname() + "', email= '" + user.getEmail() + "', isAdmin=" + user.isAdmin() + " where id=" + user.getId();
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;

    }
 @Override
    public boolean updatePassword(User user) {

        boolean flag = false;

        try {
            String sql = "update user set password='" + user.getPassword() + "' where id=" + user.getId();
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;

    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM user WHERE user_id=" + id;
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    @Override
    public User getLogger(String email) {
        User user = null;
        try {
            user = new User();
            String sql = "SELECT * FROM user  WHERE email= '" + email + "'";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setOtherNames(resultSet.getString("otherNames"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setAdmin(resultSet.getBoolean("isAdmin"));


            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(user.toString());
        return user;
    }



}
