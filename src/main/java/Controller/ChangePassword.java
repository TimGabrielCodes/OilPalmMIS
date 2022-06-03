package Controller;

import DAO.ChartsDAO;
import DAO.ChartsDAOImpl;
import DAO.UserDAO;
import DAO.UserDAOImpl;
import Model.User;
import Util.DashboardUtil;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/changePassword")
public class ChangePassword extends HttpServlet {
    UserDAO userDAO = null;
    RequestDispatcher dispatcher = null;
    private ChartsDAO chartsDAO;

    public ChangePassword() {
        userDAO = new UserDAOImpl();
        chartsDAO = new ChartsDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Called Post");
        User user = userDAO.getLogger((String) request.getSession().getAttribute("email"));
String oldPassword = user.getPassword();
        String password1 = request.getParameter("newPassword1");
        String password2 = request.getParameter("newPassword2");

        System.out.printf("Old password is "+ oldPassword);
        System.out.printf(" password1 is "+ password1);
        System.out.printf(" password2 is "+ password2);
        System.out.printf("Old password is "+ oldPassword);
        if( user.getPassword().equals(oldPassword) ){

                if (userDAO.updatePassword(user)) {
                    request.setAttribute("message", "Success");
                }else {
                    request.setAttribute("message", "An Error Occured");
                }
        }
        else {
            request.setAttribute("message", "Old password incorrect");

        }

        dispatcher = getServletContext().getRequestDispatcher("/dashboard");
        dispatcher.forward(request, response);
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
            request.setAttribute("list", list);
            request.setAttribute("util", util);
           request.setAttribute("incomeCostPlot", incomeCostPlot);
           request.setAttribute("incomeDatePlot", incomeDatePlot);
           request.setAttribute("expenseCategoryPlot", expenseCategoryPlot);
           request.setAttribute("harvestAndStock", harvestAndStockPlot);
            request.setAttribute("title", "Admin Dashboard");
            dispatcher = request.getRequestDispatcher("/Views/Admin/dashboard.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
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
