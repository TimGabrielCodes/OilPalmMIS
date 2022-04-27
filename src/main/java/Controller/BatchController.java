package Controller;

import DAO.BatchDAO;
import DAO.BatchDAOImpl;
import DAO.UserDAO;
import DAO.UserDAOImpl;
import Model.Batch;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet(value = "/batches")
public class BatchController extends HttpServlet {
    BatchDAO batchDAO;
    private UserDAO userDAO;

    public BatchController(){
        batchDAO = new BatchDAOImpl();
        userDAO = new UserDAOImpl();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date batchDate = Date.valueOf(request.getParameter("batchDate"));

        User logger = userDAO.getLogger((String) request.getSession().getAttribute("email"));
        String batchId = request.getParameter("batchId");
        String batchName = request.getParameter("batchName");
        LocalDate localDate = batchDate.toLocalDate();

        Batch batch = new Batch();
        batch.setBatchName(batchName);
        batch.setBatchMonth(localDate.getMonthValue());
        batch.setLogger(logger);
        batch.setBatchDate(Date.valueOf(localDate));
        System.out.println("Date Value" + batchDate);
        System.out.println("Batch to save" + batch.toString());
        if (batchId.isEmpty()) {
            //save if
            if (batchDAO.saveBatch(batch)) {
                request.setAttribute("message", "batch saved Successfully");
            }
        } else {
            //update
            batch.setId(Integer.parseInt(batchId));

            if (batchDAO.updateBatch(batch)) {
                request.setAttribute("message", "Batch updated Successfully");
            }
        }





    }
}
