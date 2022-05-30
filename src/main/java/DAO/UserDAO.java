package DAO;

import Model.User;
import Model.Vendor;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> get() throws SQLException;

    boolean saveUser(User user);

    User get(int id);


    User getLogger(String email);

    boolean updateUser(User user);

    boolean updatePassword(User user);

    boolean delete(int id);




}
