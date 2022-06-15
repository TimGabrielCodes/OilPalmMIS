package DAO;

import Model.MillingExpense;
import Model.MillingProduct;
import Util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MillingProductDAOImpl implements MillingProductDAO{

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<MillingProduct> list = null;
    MillingProduct millingProduct = null;
    PreparedStatement preparedStmt = null;
    @Override
    public MillingProduct get() {

        try {

            String sql = "select * from millingProduct ";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            millingProduct = new MillingProduct();
            while (resultSet.next()) {
                millingProduct.setFibreOilCan(resultSet.getInt("fibreOilCan"));
                millingProduct.setPalmOilDrum(resultSet.getInt("palmOilDrum"));
                millingProduct.setPalmOilCan(resultSet.getInt("palmOilCan"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return millingProduct;
    }

    @Override
    public Boolean update(MillingProduct millingProduct) {
        return null;
    }
}
