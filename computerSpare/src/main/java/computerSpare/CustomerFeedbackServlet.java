package computerSpare;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CustomerFeedbackServlet
 */
@WebServlet("/CustomerFeedbackServlet") // Annotation for servlet mapping
public class CustomerFeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handling HTTP POST requests for customer feedback
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Retrieving feedback details from the form parameters
        String date = request.getParameter("date");
        String name = request.getParameter("name");
        String feedbacks = request.getParameter("feedbacks");

        // Variable to catch the output value from the return value from dbutil
        boolean isTrue;

        // Creating an instance of the interface using polymorphism
        iCustomerDButil customerDBUtil = new CustomerDBUtil();

        // Inserting feedback details into the database using polymorphism
        isTrue = customerDBUtil.insertfeedback(date, name, feedbacks);

        // Redirecting based on the success of the feedback insertion using encapsulation
        if (isTrue) {
            // Successful insertion, forwarding to "frontmain.jsp"
            RequestDispatcher dis = request.getRequestDispatcher("frontmain.jsp");
            dis.forward(request, response);
        } else {
            // Unsuccessful insertion, forwarding to "frontmain.jsp" (you might want to handle errors more effectively)
            RequestDispatcher dis2 = request.getRequestDispatcher("frontmain.jsp");
            dis2.forward(request, response);
        }
    }
}
