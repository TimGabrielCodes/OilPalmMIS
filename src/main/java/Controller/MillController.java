package Controller;

import DAO.*;
import Model.*;

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
    private final UserDAO userDAO;
    MillDAO millDAO;
    MillingExpenseDAO millingExpenseDAO;
    HarvestDAO harvestDAO;
    private RequestDispatcher dispatcher;

    public MillController() {
        millDAO = new MillDAOImpl();
        userDAO = new UserDAOImpl();
        millingExpenseDAO = new MillingExpenseDAOImpl();
        harvestDAO = new HarvestDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        System.out.println("Post HIT");
        User logger = userDAO.getLogger((String) request.getSession().getAttribute("email"));
        String millId = request.getParameter("millId");
        String millExpenseId = request.getParameter("millExpenseId");

        String harvestID = request.getParameter("harId");
        String numberOfPresses = request.getParameter("numberOfPresses");
        String millingDate = request.getParameter("millingDate");
        String fuel = request.getParameter("fuel");
        String storage = request.getParameter("storage");
        String adhocLabour = request.getParameter("adhocLabour");
        String firewood = request.getParameter("firewood");
        String plantParts = request.getParameter("plantParts");
        Integer palmOilDrum = Integer.valueOf(request.getParameter("palm_oil_drum"));
        Integer palmOilCan = Integer.valueOf(request.getParameter("palm_oil_can"));
        Integer fibreOilCan = Integer.valueOf(request.getParameter("fibre_oil_can"));


        Mill mill = new Mill();
        MillingProduct millingProduct = new MillingProduct();
        millingProduct.setPalmOilCan(palmOilCan);
        millingProduct.setPalmOilDrum(palmOilDrum);
        millingProduct.setFibreOilCan(fibreOilCan);

        Harvest harvest = new HarvestDAOImpl().get(Integer.parseInt(harvestID));

        mill.setLogger(logger);
        mill.setBatch(harvest.getBatch());
        mill.setHarvestStock(harvest.getStockInBunches());
        mill.setNumberOfPresses(Integer.valueOf(numberOfPresses));
        mill.setMillingDate(Date.valueOf(millingDate));


//        Create Milling Expense Object
        MillingExpense millingExpense = new MillingExpense();
        millingExpense.setFuel(Double.valueOf(fuel));
        millingExpense.setStorage(Double.valueOf(storage));
        millingExpense.setHarvestStockCost(harvest.getHarvestStockCost());
        millingExpense.setAdhocLabour(Double.valueOf(adhocLabour));
        millingExpense.setFirewood(Double.valueOf(firewood));
//        millingExpense.setFruitPurchase(Double.valueOf(fruitPurchase));
        millingExpense.setPlantParts(Double.valueOf(plantParts));
        millingExpense.setLogger(logger);
        mill.setMillingExpense(millingExpense);


        if (millId.isEmpty()) {
            //save if

            if (millDAO.saveMill(mill)) {
                mill = millDAO.getByBatch(harvest.getBatch().getId());


                millingExpense.setMill(mill);
                harvestDAO.millHarvest(harvest);
                System.out.println("Is harvest milled ? " + harvest.isMilled());

                if (millingExpenseDAO.saveMillingExpense(millingExpense)) {
                    request.setAttribute("message", "mill saved Successfully");
                    //                }

                }

            }
        } else {
            //update
            mill.setId(Integer.parseInt(millId));
            millingExpense.setId(Integer.parseInt(millExpenseId));


            if (millDAO.updateMill(mill) && millingExpenseDAO.updateMillingExpense(millingExpense)) {
                request.setAttribute("message", "Mill updated Successfully");
            }
        }
        listMills(request, response);


    }

    public void listMills(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<Mill> list = millDAO.get();
//            System.out.println("Listing Mills");
            request.setAttribute("list", list);
            request.setAttribute("title", "Mill List");
            dispatcher = request.getRequestDispatcher("/Views/Admin/Mills.jsp");
            dispatcher.forward(request, response);
            return;
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
            return;
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteMill(HttpServletRequest request, HttpServletResponse response) throws ServletException {


        String id = request.getParameter("id");


        if (millDAO.delete(Integer.parseInt(id))) {
            request.setAttribute("title", "Delete Mill");
            request.setAttribute("message", "Mill Deleted!");

        }
        listMills(request, response);

    }

    public void editMill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Edit Mill");
        String id = request.getParameter("id");
        Mill mill = millDAO.get(Integer.parseInt(id));
        MillingExpense millingExpense = millingExpenseDAO.get(mill);
        mill.setMillingExpense(millingExpense);
//        System.out.println("Mill to edit" + mill.toString());
//        System.out.println("Milling Expense to edit" + millingExpense.toString());
        request.setAttribute("title", "Edit Mill");
        request.setAttribute("mill", mill);
        dispatcher = request.getRequestDispatcher("/Views/Admin/EditMill.jsp");
        dispatcher.forward(request, response);


    }

}
