package Controller;

import DAO.*;
import Model.*;
import Model.Expense;

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

@WebServlet(value = "/expenses")
public class ExpenseController extends HttpServlet {
    private final UserDAO userDAO;
    ExpenseDAO expenseDAO;
    HarvestDAO harvestDAO;
    private RequestDispatcher dispatcher;

    public ExpenseController() {
        expenseDAO = new ExpenseDAOImpl();
        userDAO = new UserDAOImpl();
        expenseDAO = new ExpenseDAOImpl();
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
                listExpenses(request, response);
                break;

            case "ADD":
                newExpense(request, response);
                break;
            case "DELETE":
                deleteExpense(request, response);
                break;
            case "EDIT":
                editExpense(request, response);

            default:
                listExpenses(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        System.out.println("Post HIT");
        User logger = userDAO.getLogger((String) request.getSession().getAttribute("email"));
        String expenseCategory = request.getParameter("category");
        Double amount = Double.valueOf(request.getParameter("amount"));
        String remark = request.getParameter("remark");
        Date date = Date.valueOf(request.getParameter("date"));
        String expenseId = request.getParameter("expenseId");

        Expense expense = new Expense();
        expense.setLogger(logger);
        expense.setExpenseCategory(ExpenseCategory.valueOf(expenseCategory));
        expense.setAmount(amount);
        expense.setRemark(remark);
        expense.setDate(date);


                if (expenseDAO.saveExpense(expense)) {
                    request.setAttribute("message", "Expense saved Successfully");
        } else {
            //update
            expense.setId(Integer.parseInt(expenseId));

            if (expenseDAO.updateExpense(expense)) {
                request.setAttribute("message", "Expense updated Successfully");
            }
        }
        listExpenses(request, response);


    }

    public void listExpenses(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<Expense> list = expenseDAO.get();
//            System.out.println("Listing Expenses");
            request.setAttribute("list", list);
            request.setAttribute("title", "Expense List");
            dispatcher = request.getRequestDispatcher("/Views/Admin/Expenses.jsp");
            dispatcher.forward(request, response);
            return;
        } catch (IOException ex) {
            Logger.getLogger(ExpenseController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void newExpense(HttpServletRequest request, HttpServletResponse response) {

        try {
            User user = userDAO.getLogger((String) request.getSession().getAttribute("email"));
            user.setFullName();
            request.setAttribute("user", user);
            request.setAttribute("title", "Create new Expense");
            dispatcher = request.getRequestDispatcher("/Views/Admin/AddExpense.jsp");

            dispatcher.forward(request, response);
            return;
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteExpense(HttpServletRequest request, HttpServletResponse response) throws ServletException {


        String id = request.getParameter("id");


        if (expenseDAO.delete(Integer.parseInt(id))) {
            request.setAttribute("title", "Delete Expense");
            request.setAttribute("message", "Expense Deleted!");

        }
        listExpenses(request, response);

    }

    public void editExpense(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Edit Expense");
        String id = request.getParameter("id");
        Expense expense = expenseDAO.get(Integer.parseInt(id));
        request.setAttribute("title", "Edit Expense");
        request.setAttribute("expense", expense);
        dispatcher = request.getRequestDispatcher("/Views/Admin/EditExpense.jsp");
        dispatcher.forward(request, response);


    }

}
