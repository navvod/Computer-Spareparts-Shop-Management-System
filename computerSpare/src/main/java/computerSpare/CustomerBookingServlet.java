package computerSpare;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CustomerBookingServlet
 */
@WebServlet("/CustomerBookingServlet") // Annotation for servlet mapping
public class CustomerBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handling HTTP POST requests for customer bookings
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Retrieving booking details from the form parameters
        String date = request.getParameter("date");
        String destination = request.getParameter("destination");
        String requests = request.getParameter("requests");

        // Variable to catch the output value from the return value from dbutil
        boolean isTrue;

        // Creating an instance of the interface using polymorphism
        iCustomerDButil customerDBUtil = new CustomerDBUtil();

        // Inserting booking details into the database using polymorphism
        isTrue = customerDBUtil.insertbooking(date, destination, requests);

        // Redirecting based on the success of the booking insertion using encapsulation
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
