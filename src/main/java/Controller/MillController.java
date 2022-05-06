package Controller;

import DAO.*;
import Model.Mill;
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

@WebServlet(value = "/mills")
public class MillController extends HttpServlet {
    MillDAO millDAO;
    private final UserDAO userDAO;
    private RequestDispatcher dispatcher;

    public MillController(){
        millDAO = new MillDAOImpl();
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
                listMills(request, response);
                break;

            case "ADD":
                newMill(request, response);
                break;
            case "DELETE":
                deleteMill(request, response);
                break;
            case "EDIT":
                editMill(request, response);

                default:
                    listMills(request, response);
                    break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Post HIT");
        User logger = userDAO.getLogger((String) request.getSession().getAttribute("email"));
        String millId = request.getParameter("millId");
        String batch = request.getParameter("batch");
        String harvestStock = request.getParameter("harvestStock");
        String stockCost = request.getParameter("stockCost");
        String numberOfPresses = request.getParameter("numberOfPresses");
        String millingDate = request.getParameter("millingDate");
        Mill mill = new Mill();
        mill.setLogger(logger);
        mill.setBatch( new BatchDAOImpl().get(batch));
        mill.setHarvestStock(Integer.valueOf(harvestStock));
        mill.setStockCost(Double.valueOf(stockCost));
        mill.setNumberOfPresses(Integer.valueOf(numberOfPresses));
        mill.setMillingDate(Date.valueOf(millingDate));
        if (millId.isEmpty()) {
            //save if
            if (millDAO.saveMill(mill)) {
                request.setAttribute("message", "mill saved Successfully");
            }
        } else {
            //update
            mill.setId(Integer.parseInt(millId));

            if (millDAO.updateMill(mill)) {
                request.setAttribute("message", "Mill updated Successfully");
            }
        }
        listMills(request, response);


    }
    public void listMills(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<Mill> list = millDAO.get();
            System.out.println("Listing Mills");
            request.setAttribute("list", list);
            request.setAttribute("title", "Mill List");
            dispatcher = request.getRequestDispatcher("/Views/Admin/Mills.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(MillController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void newMill(HttpServletRequest request, HttpServletResponse response) {

        try {
            User user = userDAO.getLogger((String) request.getSession().getAttribute("email"));
            user.setFullName();
            request.setAttribute("user", user);
            request.setAttribute("title", "Create new Mill");
            dispatcher = request.getRequestDispatcher("/Views/Admin/AddMill.jsp");

            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
    public void deleteMill(HttpServletRequest request, HttpServletResponse response) throws ServletException{


        String id = request.getParameter("id");


        if(millDAO.delete(Integer.parseInt(id))){
            request.setAttribute("title", "Delete Mill");
            request.setAttribute("message", "Mill Deleted!");

        }
        listMills(request, response);

    }
    public void editMill(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        Mill mill = millDAO.get(Integer.parseInt(id));
        request.setAttribute("title", "Edit Mill");
        request.setAttribute("mill", mill);
        dispatcher = request.getRequestDispatcher("/Views/Admin/AddMill.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

}
