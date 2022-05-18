package DAO;

import Util.DBConnectionUtil;
import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChartsDAOImpl implements  ChartsDAO {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    @Override
    public String getCurrentMonth() {

        return null;
    }

    @Override
    public int getUnmilledBatches() {
        int count = 0;
        try {

            String sql = "SELECT COUNT(*) as prod FROM harvest group by milled having  milled = 0";
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
            Logger.getLogger(ChartsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    @Override
    public int getMilledBatches() {
        int count = 0;
        try {

            String sql = "SELECT COUNT(*) as prod FROM harvest group by milled having  milled = 1";
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
            Logger.getLogger(ChartsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    @Override
    public String getIncomeCostPlot() {
        Map<Object, Object> map = null;
        List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
        String dataPoints = null;
        String sql = "SELECT incomeType, SUM(amount) as sum " +
                "FROM income " +
                "GROUP BY incomeType";
        String xVal;
        Double yVal;
        Gson gson = new Gson();
        try {
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                xVal = resultSet.getString("incomeType");
                yVal = (resultSet.getDouble("sum"));
                map = new HashMap<Object, Object>();
                map.put("x", xVal );
                map.put("y", yVal);
                list.add(map);
                dataPoints = gson.toJson(list);
                   }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dataPoints;
    }
}