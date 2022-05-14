package Controller;

import DAO.IncomeDAO;
import DAO.IncomeDAOImpl;
import DAO.UserDAO;
import DAO.UserDAOImpl;
import Model.Income;
import Model.IncomeType;
import Model.ProductUnit;
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
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(value = "/sales")
public class IncomeController extends HttpServlet {
    IncomeDAO incomeDAO;
    private final UserDAO userDAO;
    private RequestDispatcher dispatcher;

    public IncomeController() {
        incomeDAO = new IncomeDAOImpl();
        userDAO = new UserDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "SALES";
        }
        switch (action) {
            case "SALES":
                listSales(request, response);
                break;

            case "NEW":
                newIncome(request, response);
                break;
            case "DELETE":
                deleteIncome(request, response);
                break;
            case "EDIT":
                editIncome(request, response);

            default:
                listSales(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String incomeType = request.getParameter("incomeType");
        String amount = request.getParameter("amount");
        String receivedFrom = request.getParameter("receivedFrom");
        String remark = request.getParameter("remark");
        String productUnit = request.getParameter("productUnit");
        Date date = Date.valueOf(request.getParameter("date"));
        System.out.println("I got this date" + date);

        User logger = userDAO.getLogger((String) request.getSession().getAttribute("email"));
        String id = request.getParameter("id");


        Income income = new Income();
        income.setIncomeType(IncomeType.valueOf(incomeType));
        income.setAmount(Double.valueOf(amount));
        income.setReceivedFrom(receivedFrom);
        income.setDate(date);
        income.setLogger(logger);
        income.setRemark(remark);
        income.setProductUnit(ProductUnit.valueOf(productUnit));

        System.out.println("Sending product to DAO " + income);
        if (id.isEmpty()) {
            //save if
            if (incomeDAO.saveIncome(income)) {
                request.setAttribute("message", "income saved Successfully");
            }
        } else {
            //update
            income.setId(Integer.parseInt(id));

            if (incomeDAO.updateIncome(income)) {
                request.setAttribute("message", "Income updated Successfully");
            }
        }
        listSales(request, response);


    }

    public void listSales(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<Income> list = incomeDAO.get();

            request.setAttribute("list", list);
            request.setAttribute("title", "Income List");
            dispatcher = request.getRequestDispatcher("/Views/Admin/Sales.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(IncomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void newIncome(HttpServletRequest request, HttpServletResponse response) {

        try {
            User user = userDAO.getLogger((String) request.getSession().getAttribute("email"));
            user.setFullName();
            request.setAttribute("user", user);
            request.setAttribute("title", "Create new Income");
            dispatcher = request.getRequestDispatcher("/Views/Admin/AddIncome.jsp");

            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteIncome(HttpServletRequest request, HttpServletResponse response) throws ServletException {


        String id = request.getParameter("id");


        if (incomeDAO.delete(Integer.parseInt(id))) {
            request.setAttribute("title", "Delete Income");
            request.setAttribute("message", "Income Deleted!");

        }
        listSales(request, response);

    }

    public void editIncome(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Income income = incomeDAO.get(Integer.parseInt(id));
        request.setAttribute("title", "Edit Income");
        request.setAttribute("income", income);
        dispatcher = request.getRequestDispatcher("/Views/Admin/AddIncome.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

}
