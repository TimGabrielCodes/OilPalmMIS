package DAO;

import Model.User;
import Model.Vendor;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> get() throws SQLException;
    List<Vendor> getVendors();
    boolean  saveUser(User user);

    User get(int id);



    User getLogger(String email);

    boolean updateUser(User user);

    boolean delete(int id);

    Vendor getVendor(String name);
    Vendor getVendor(int id);

    boolean addVendor(Vendor vendor);

    boolean deleteVendor(int id);

    boolean update (Vendor vendor);

    int getUserCount();
    int getManagerCount();
    int getClerkCount();
    int getWarehouseManagerCount();
    int getAdminCount();
    int getTransactionCount(String name);
    int getProductCount(int id);
    int getTransactionCount();

    int getVendorCount();

    List<User> getManagers();
    List<User> getWarehouseManagers();
    List<User> getClerks();


}
