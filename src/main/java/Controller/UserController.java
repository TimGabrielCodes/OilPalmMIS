package Controller;

import DAO.*;
import Model.MillingProduct;
import Model.StockItem;
import Model.User;
import Util.DashboardUtil;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/admin")
public class UserController extends HttpServlet {
    UserDAO userDAO = null;
    RequestDispatcher dispatcher = null;
    private ChartsDAO chartsDAO;

    private MillingProductDAO millingProductDAO;

    public UserController() {
        userDAO = new UserDAOImpl();
        chartsDAO = new ChartsDAOImpl();
        millingProductDAO = new MillingProductDAOImpl() {
        };
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "DASHBOARD";

        }
        switch (action) {
            case "VIEWPROFILE":
                viewProfile(request, response);
                break;
            default:
                dashboard(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String otherNames = request.getParameter("otherNames");
        String email = request.getParameter("email");
        String password1 = request.getParameter("pass1");
        String userID = request.getParameter("user_id");
        String surname = request.getParameter("surname");
        boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
        User user = new User();
        user.setFirstName(firstName);
        user.setOtherNames(otherNames);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(password1);
        user.setAdmin(admin);
        if (userID.isEmpty()) {
            //save if
            if (userDAO.saveUser(user)) {
                request.setAttribute("message", "User saved Successfully");
            }
        } else {
            //update
            user.setId(Integer.parseInt(userID));
            if (userDAO.updateUser(user)) {
                request.setAttribute("message", "User updated Successfully");
            }
        }

        dashboard(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void dashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<User> list = userDAO.get();
            DashboardUtil util = new DashboardUtil();
            util.setUnMilledBatches(chartsDAO.getUnmilledBatches());
            util.setMilledBatches(chartsDAO.getMilledBatches());
            LocalDate today = LocalDate.now(ZoneId.systemDefault());
            util.setMonth(today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
            String incomeCostPlot = chartsDAO.getIncomeCostPlot();
            String incomeDatePlot = chartsDAO.getIncomeDatePlot();
            String expenseCategoryPlot = chartsDAO.getExpenseCategoryCost();
            String harvestAndStockPlot = chartsDAO.getHarvestandStockPlot();
            MillingProduct millingProduct = millingProductDAO.get();
            System.out.println("Milling Product = " + millingProduct.toString());
            request.setAttribute("list", list);
            request.setAttribute("util", util);
           request.setAttribute("incomeCostPlot", incomeCostPlot);
           request.setAttribute("incomeDatePlot", incomeDatePlot);
           request.setAttribute("expenseCategoryPlot", expenseCategoryPlot);
           request.setAttribute("harvestAndStock", harvestAndStockPlot);
           request.setAttribute("millingProduct", millingProduct);

            request.setAttribute("title", "Admin Dashboard");
            dispatcher = request.getRequestDispatcher("/Views/Admin/dashboard.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewProfile(HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = userDAO.getLogger((String) request.getSession().getAttribute("email"));
            user.setFullName();
            request.setAttribute("title", "Profile Settings");
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("/Views/Admin/page-settings.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
