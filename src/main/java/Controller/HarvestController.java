package Controller;

import DAO.*;
import Model.Harvest;
import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(value = "/harvests")
public class HarvestController extends HttpServlet {
    HarvestDAO harvestDAO;
    private final UserDAO userDAO;
    private RequestDispatcher dispatcher;

    public HarvestController(){
        harvestDAO = new HarvestDAOImpl();
        userDAO = new UserDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null){
            action = "MILLS";
        }
        switch (action) {
            case "MILLS":
                listHarvests(request, response);
                break;

            case "ADD":
                newHarvest(request, response);
                break;
            case "DELETE":
                deleteHarvest(request, response);
                break;
            case "EDIT":
                editHarvest(request, response);

                default:
                    listHarvests(request, response);
                    break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Post HIT");
        User logger = userDAO.getLogger((String) request.getSession().getAttribute("email"));
        String harvestId = request.getParameter("harvestId");
        String batch = request.getParameter("batch");
        String harvestStock = request.getParameter("harvestStock");
        String stockCost = request.getParameter("stockCost");
        String numberOfPresses = request.getParameter("numberOfPresses");
        String harvestingDate = request.getParameter("harvestingDate");
        Harvest harvest = new Harvest();
//        harvest.setLogger(logger);
//        harvest.setBatch( new BatchDAOImpl().get(batch));
//        harvest.setHarvestStock(Integer.valueOf(harvestStock));
//        harvest.setStockCost(Double.valueOf(stockCost));
//        harvest.setNumberOfPresses(Integer.valueOf(numberOfPresses));
//        harvest.setHarvestingDate(Date.valueOf(harvestingDate));
        if (harvestId.isEmpty()) {
            //save if
            if (harvestDAO.saveHarvest(harvest)) {
                request.setAttribute("message", "harvest saved Successfully");
            }
        } else {
            //update
            harvest.setId(Integer.parseInt(harvestId));

            if (harvestDAO.updateHarvest(harvest)) {
                request.setAttribute("message", "Harvest updated Successfully");
            }
        }
        listHarvests(request, response);


    }
    public void listHarvests(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<Harvest> list = harvestDAO.get();
            System.out.println("Listing Harvests");
            request.setAttribute("list", list);
            request.setAttribute("title", "Harvest List");
            dispatcher = request.getRequestDispatcher("/Views/Admin/Harvests.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(HarvestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void newHarvest(HttpServletRequest request, HttpServletResponse response) {

        try {
            User user = userDAO.getLogger((String) request.getSession().getAttribute("email"));
            user.setFullName();
            request.setAttribute("user", user);
            request.setAttribute("title", "Create new Harvest");
            dispatcher = request.getRequestDispatcher("/Views/Admin/AddHarvest.jsp");

            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
    public void deleteHarvest(HttpServletRequest request, HttpServletResponse response) throws ServletException{


        String id = request.getParameter("id");


        if(harvestDAO.delete(Integer.parseInt(id))){
            request.setAttribute("title", "Delete Harvest");
            request.setAttribute("message", "Harvest Deleted!");

        }
        listHarvests(request, response);

    }
    public void editHarvest(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        Harvest harvest = harvestDAO.get(Integer.parseInt(id));
        request.setAttribute("title", "Edit Harvest");
        request.setAttribute("harvest", harvest);
        dispatcher = request.getRequestDispatcher("/Views/Admin/AddHarvest.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

}
