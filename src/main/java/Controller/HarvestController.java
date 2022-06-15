package Controller;

import DAO.*;
import Model.Batch;
import Model.Harvest;
import Model.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(value = "/harvests")
public class HarvestController extends HttpServlet {
    private final UserDAO userDAO;
    HarvestDAO harvestDAO;

    BatchDAO batchDAO;
    private RequestDispatcher dispatcher;

    public HarvestController() {
        harvestDAO = new HarvestDAOImpl();
        userDAO = new UserDAOImpl();
        batchDAO = new BatchDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "BATCHES";
        }
        switch (action) {
            case "BATCHES":
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
        String harvestDate = (request.getParameter("dateHarvested"));
        User logger = userDAO.getLogger((String) request.getSession().getAttribute("email"));
        String harvestId = request.getParameter("id");
        String batch = request.getParameter("batch");
        Batch batchObject = new BatchDAOImpl().get(batch);
        String stockInBunches = request.getParameter("stockInBunches");
        String costPerBunch = request.getParameter("costPerBunch");
        String otherCosts = request.getParameter("otherCosts");
        String honorarium = request.getParameter("honorarium");
        Harvest harvest = new Harvest();
        harvest.setLogger(logger);
        harvest.setBatch(batchObject);
        harvest.setDateAdded(Date.valueOf(harvestDate));
        harvest.setMilled(false);
        harvest.setStockInBunches(Integer.parseInt(stockInBunches));
        harvest.setCostPerBunch(Double.valueOf(costPerBunch));
        harvest.setOtherCosts(Double.valueOf(otherCosts));
        if(honorarium.isEmpty()){
            harvest.setHonorarium(0.0);
        }else{
            harvest.setHonorarium(Double.valueOf(honorarium));
        }

        if (harvestId.isEmpty()) {
            if (harvestDAO.saveHarvest(harvest)) {
                batchDAO.harvestBatch(batchObject);

                request.setAttribute("message", "harvest saved Successfully");
            }

        } else {
            harvest.setId(Integer.parseInt(harvestId));
            if (harvestDAO.updateHarvest(harvest)) {
                request.setAttribute("message", "Harvest Updated Successfully");
            }

        }


        listHarvests(request, response);


    }

    public void listHarvests(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<Harvest> list = harvestDAO.get();

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

    public void deleteHarvest(HttpServletRequest request, HttpServletResponse response) throws ServletException {


        String id = request.getParameter("id");


        if (harvestDAO.delete(Integer.parseInt(id))) {
            request.setAttribute("title", "Delete Harvest");
            request.setAttribute("message", "Harvest Deleted!");

        }
        listHarvests(request, response);

    }

    public void editHarvest(HttpServletRequest request, HttpServletResponse response) {
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

    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {

        PrintWriter out = res.getWriter();
        res.setContentType("text/plain");

        Enumeration<String> parameterNames = req.getParameterNames();

        while (parameterNames.hasMoreElements()) {

            String paramName = parameterNames.nextElement();
            out.write(paramName);
            out.write("n");

            String[] paramValues = req.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
                String paramValue = paramValues[i];
                out.write("t" + paramValue);
                out.write("n");
            }

        }

        out.close();

    }
}
