package Controller;

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
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/admin")
public class UserController extends HttpServlet {
    UserDAO userDAO = null;
    RequestDispatcher dispatcher = null;

    public UserController() {
        userDAO = new UserDAOImpl();
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
            case "ADD":
                newUser(request, response);
                break;

            case "EDIT":
                getSingleUser(request, response);
                break;

            case "DELETE":
                deleteUser(request, response);
                break;
            case "MANAGERS":
                listManagers(request, response);
                break;
            case "WAREHOUSE":
                listWarehouseManagers(request, response);
                break;

            case "CLERKS":
                listClerks(request, response);
                break;

            default:
                dashboard(request, response);
                break;
        }
//processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String otherNames = request.getParameter("otherNames");
        String email = request.getParameter("email");
        String password1 = request.getParameter("pass1");
        String password2 = request.getParameter("pass2");
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
            request.setAttribute("list", list);
            request.setAttribute("util", util);
            request.setAttribute("title", "Admin Dashboard");
            System.out.println("Going to admin dashboard");
            dispatcher = request.getRequestDispatcher("/Views/Admin/dashboard.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getSingleUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        System.out.println("get single User");
        DashboardUtil util = new DashboardUtil();
        util.setAdmin(userDAO.getAdminCount());
        util.setManagers(userDAO.getManagerCount());
        util.setUsers(userDAO.getUserCount());
        util.setClerk(userDAO.getClerkCount());
        util.setWarehouse(userDAO.getWarehouseManagerCount());
        request.setAttribute("util", util);
        String id = request.getParameter("id");
        User user = userDAO.get(Integer.parseInt(id));
        System.out.println("This is the user that we want to edit: " + user.toString());
        request.setAttribute("title", "Edit User");
        request.setAttribute("user", user);
        dispatcher = request.getRequestDispatcher("/Views/Admin/add_user.jsp");
        dispatcher.forward(request, response);

    }

    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{


        String id = request.getParameter("id");

        User user = userDAO.get(Integer.parseInt(id));
        if(userDAO.delete(Integer.parseInt(id))){
            request.setAttribute("title", "Delete User");
            request.setAttribute("message", "User Deleted!");

        }
        dashboard(request, response);

    }
    public void newUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        System.out.println("Add new user to database "
                + "MySQL and Postgresql");
        DashboardUtil util = new DashboardUtil();
        util.setAdmin(userDAO.getAdminCount());
        util.setManagers(userDAO.getManagerCount());
        util.setUsers(userDAO.getUserCount());
        util.setClerk(userDAO.getClerkCount());
        util.setWarehouse(userDAO.getWarehouseManagerCount());
        request.setAttribute("util", util);
        request.setAttribute("title", "Create New User");
        dispatcher = request.getRequestDispatcher("/Views/Admin/add_user.jsp");
        dispatcher.forward(request, response);

    }

    private void listWarehouseManagers(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<User> list = userDAO.getWarehouseManagers();
            DashboardUtil util = new DashboardUtil();
            util.setAdmin(userDAO.getAdminCount());
            util.setManagers(userDAO.getManagerCount());
            util.setUsers(userDAO.getUserCount());
            util.setClerk(userDAO.getClerkCount());
            util.setWarehouse(userDAO.getWarehouseManagerCount());

            request.setAttribute("list", list);
            request.setAttribute("util", util);
            request.setAttribute("title", "Users");
            dispatcher = request.getRequestDispatcher("/Views/Admin/user_list.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void listClerks(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<User> list = userDAO.getClerks();
            DashboardUtil util = new DashboardUtil();
            util.setAdmin(userDAO.getAdminCount());
            util.setManagers(userDAO.getManagerCount());
            util.setUsers(userDAO.getUserCount());
            util.setClerk(userDAO.getClerkCount());
            util.setWarehouse(userDAO.getWarehouseManagerCount());

            request.setAttribute("list", list);
            request.setAttribute("util", util);
            request.setAttribute("title", "Users");
            dispatcher = request.getRequestDispatcher("/Views/Admin/user_list.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void listManagers(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<User> list = userDAO.getManagers();
            DashboardUtil util = new DashboardUtil();
            util.setAdmin(userDAO.getAdminCount());
            util.setManagers(userDAO.getManagerCount());
            util.setUsers(userDAO.getUserCount());
            util.setClerk(userDAO.getClerkCount());
            util.setWarehouse(userDAO.getWarehouseManagerCount());

            request.setAttribute("list", list);
            request.setAttribute("util", util);
            request.setAttribute("title", "Users");
            dispatcher = request.getRequestDispatcher("/Views/Admin/user_list.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void viewProfile(HttpServletRequest request, HttpServletResponse response){
        try {
            System.out.println("the page");
            User user = userDAO.getLogger((String) request.getSession().getAttribute("email"));
            user.setFullName();
        request.setAttribute("user", user);
        dispatcher = request.getRequestDispatcher("/Views/Admin/page-settings.jsp");

            dispatcher.forward(request, response);
            System.out.println("done");
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            User user = userDAO.getLogger((String) request.getSession().getAttribute("email"));
            // List<Product> list = productDAO.get();
//            ProductDAO pr = new ProductDAOImpl();
            UserDAO us = new UserDAOImpl();
//            int productCount= pr.countProducts();
//            int transCount = us.getTransactionCount(user.getFullName());
//            int products =  us.getProductCount(user.getUser_id());
//            List<Transaction> list = productDAO.getUserTransactions(user.getFullName());

//            request.setAttribute("list", list);
//
//            request.setAttribute("stockCount", productCount);
//            request.setAttribute("transCount", transCount);
//            request.setAttribute("products", products);
//            request.setAttribute("list", list);
            request.setAttribute("title", "Dashboard");
            dispatcher = request.getRequestDispatcher("/Views/Clerk/dashboard.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
//            Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
}
