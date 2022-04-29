package DAO;

import Model.User;
import Model.Vendor;
import Util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAOImpl implements UserDAO{
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
    public List<Vendor> getVendors() {

        try {
            vendorList = new ArrayList<Vendor>();
            String sql = "select * from vendor";
            connection = DBConnectionUtil.openConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                vendor = new Vendor();

                vendor.setCreated_by(resultSet.getInt("created_by"));
                vendor.setVendor_id(resultSet.getInt("vendor_id"));
                vendor.setVendor_name(resultSet.getString("vendor_name"));

                vendorList.add(vendor);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return vendorList;

    }

    @Override
    public boolean saveUser(User user) {
        boolean flag = false;
        try {


            String sql = "insert into user(firstName, otherNames, surname, email, password, isAdmin) "
                    + "values('" + user.getFirstName() + "','" + user.getOtherNames() + "','" + user.getSurname() + "','" + user.getEmail() + "','" + user.getEmail() + "','" + user.getPassword() + "',"+ user.isAdmin()+")";
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
            String sql = "update user set firstName='" + user.getFirstName() + "', otherNames='" + user.getOtherNames() + "', surname ='" + user.getSurname() + "', email= '" + user.getEmail()+ "', isAdmin="  + user.isAdmin() +" where id=" + user.getId() ;
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

    @Override
    public Vendor getVendor(String id) {
        Vendor vendor = null;
        try {
            vendor = new Vendor();
            String sql = "SELECT * FROM vendor WHERE vendor_id=" + id;
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                vendor.setCreated_by(resultSet.getInt("created_by"));
                vendor.setVendor_name(resultSet.getString("vendor_name"));
                vendor.setVendor_id(resultSet.getInt("vendor_Id"));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(user.toString());
        return vendor;
    }

    @Override
    public Vendor getVendor(int id) {
        Vendor vendor = null;
        try {
            vendor = new Vendor();
            String sql = "SELECT * FROM vendor WHERE vendor_id=" + id;
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                vendor.setCreated_by(resultSet.getInt("created_by"));
                vendor.setVendor_name(resultSet.getString("vendor_name"));
                vendor.setVendor_id(resultSet.getInt("vendor_Id"));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(user.toString());
        return vendor;
    }

    @Override
    public boolean addVendor(Vendor vendor) {
        boolean flag = false;
        try {

            String sql = "insert into vendor(vendor_name, created_by) "
                    + "values('" + vendor.getVendor_name() + "','" + vendor.getCreated_by() + "')";
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
    public boolean deleteVendor(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM vendor WHERE vendor_Id =" + id;
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
    public boolean update(Vendor vendor) {
        boolean flag = false;
        try {
            String sql = "update vendor set vendor_name='" + vendor.getVendor_name() + "' where vendor_Id='" + vendor.getVendor_id() + "'";
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
    public int getUserCount() {
        int count = 0;
        try {

            String sql = "SELECT COUNT(*)  as users from user";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                count = resultSet.getInt("users");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    public int getAdminCount() {
        int count = 0;
        try {

            String sql = "SELECT COUNT(*) as admin FROM user GROUP BY role HAVING role = 'Administrator'";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                count = resultSet.getInt("admin");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    public int getClerkCount() {
        int count = 0;
        try {

            String sql = "SELECT COUNT(*) as Clerk FROM user GROUP BY role HAVING role = 'Clerk'";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                count = resultSet.getInt("Clerk");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    public int getWarehouseManagerCount() {
        int count = 0;
        try {

            String sql = "SELECT COUNT(*) as warehouse FROM user GROUP BY role HAVING role = 'Warehouse Manager'";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                count = resultSet.getInt("warehouse");
                System.out.println("Warehouse mg value  " + count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    public int getManagerCount() {
        int count = 0;
        try {

            String sql = "SELECT COUNT(*) as manager FROM user GROUP BY role HAVING role = 'Manager' ";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
//SELECT COUNT(*) as manager FROM user GROUP BY role HAVING role like '%Manager'
            while (resultSet.next()) {
                count = resultSet.getInt("manager");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    @Override
    public int getTransactionCount(String name) {
        int count = 0;
        try {

            String sql = "SELECT COUNT(*) as trans FROM transaction GROUP BY logger HAVING logger= '"+name+"' ";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
//SELECT COUNT(*) as manager FROM user GROUP BY role HAVING role like '%Manager'
            while (resultSet.next()) {
                count = resultSet.getInt("trans");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }

    @Override
    public int getProductCount(int id) {
        int count = 0;
        try {

            String sql = "SELECT COUNT(*) as prod FROM product GROUP BY logger_id HAVING logger_id= "+id;
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
//SELECT COUNT(*) as manager FROM user GROUP BY role HAVING role like '%Manager'
            while (resultSet.next()) {
                count = resultSet.getInt("prod");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }

    @Override
    public int getTransactionCount() {
        int count = 0;
        try {

            String sql = "SELECT COUNT(*) as prod FROM transaction";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
//SELECT COUNT(*) as manager FROM user GROUP BY role HAVING role like '%Manager'
            while (resultSet.next()) {
                count = resultSet.getInt("prod");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }



    @Override
    public int getVendorCount() {
        int count = 0;
        try {

            String sql = "SELECT COUNT(*) as prod FROM vendor ";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
//SELECT COUNT(*) as manager FROM user GROUP BY role HAVING role like '%Manager'
            while (resultSet.next()) {
                count = resultSet.getInt("prod");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    @Override
    public List<User> getManagers() {
        try {
            list = new ArrayList<User>();
            String sql = "select * from user where role ='Manager'";
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
    public List<User> getWarehouseManagers() {
        try {
            list = new ArrayList<User>();
            String sql = "select * from user where role ='Warehouse Manager'";
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

        return list;  }

    @Override
    public List<User> getClerks() {
        try {
            list = new ArrayList<User>();
            String sql = "select * from user where role ='Clerk'";
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

        return list;}

}
