package Controller;

import DAO.LoginDAO;
import DAO.LoginDAOImpl;
import DAO.UserDAO;
import DAO.UserDAOImpl;
import Model.Login;
import Model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/loginprocess")
public class LoginController extends HttpServlet {
    LoginDAO loginDAO = null;
    User user;
    UserDAO userDAO;

    public LoginController() {
        loginDAO = new LoginDAOImpl();
        userDAO = new UserDAOImpl();
        user = new User();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Login login = new Login();
        login.setEmail(request.getParameter("email"));


        login.setPassword(request.getParameter("password"));
//        System.out.println("Logging in" +login.toString());
        String status = loginDAO.authenticate(login);
//        System.out.println(status);

        if (status.equals("true")) {
            user = userDAO.getLogger(login.getEmail());
            session.setAttribute("email", login.getEmail());
            session.setAttribute("loggedIn", user);
            response.sendRedirect("dashboard");
        }
        if (status.equals("false")) {
            response.sendRedirect("index.jsp?status=false");
        }
        if (status.equals("error")) {
            response.sendRedirect("index.jsp?status=error");
        }
    }
}
