// UpdateBookingServlet.java

package computerSpare;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class UpdateBookingServlet
 * This servlet handles updating booking information.
 */
@WebServlet("/UpdateBookingServlet")
public class UpdateBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles HTTP POST requests for updating booking information.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve parameters from the request
        String idbooking = request.getParameter("idbooking");
        String date = request.getParameter("date");
        String destination = request.getParameter("destination");
        String requests = request.getParameter("requests");

        // Flag to check if the update was successful
        boolean isUpdateSuccessful;

        // Create an instance of the interface using polymorphism
        iCustomerDButil dbUtil = new CustomerDBUtil();

        // Update the booking information in the database
        isUpdateSuccessful = dbUtil.updatebooking(idbooking, date, destination, requests);

        if (isUpdateSuccessful) {
            // Retrieve updated booking details for display
            List<Booking> bookDetails = dbUtil.getBookingDetails(idbooking);
            request.setAttribute("bookDetails", bookDetails);

            // Forward the request and response to the BookingView.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("BookingView.jsp");
            dispatcher.forward(request, response);
        }
        // Add handling for the case where the update is not successful if needed
    }
}
