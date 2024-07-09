// DeleteBookingServlet.java

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
 * Servlet implementation class DeleteBookingServlet
 * This servlet handles the deletion of a booking.
 */
@WebServlet("/DeleteBookingServlet")
public class DeleteBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles HTTP POST requests for deleting a booking.
     * Uses the iCustomerDButil interface to interact with the database.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the idbooking parameter from the request
        String idbooking = request.getParameter("idbooking");
        boolean isDeletionSuccessful;

        // Create an instance of the interface using polymorphism
        iCustomerDButil dbUtil = new CustomerDBUtil();

        // Delete the booking and capture the result
        isDeletionSuccessful = dbUtil.deleteBooking(idbooking);

        if (isDeletionSuccessful) {
            // Successful deletion, navigate to the main page
            RequestDispatcher dispatcher = request.getRequestDispatcher("frontmain.jsp");
            dispatcher.forward(request, response);
        } else {
            // Unsuccessful deletion, retrieve booking details and forward to the Booking.jsp for further action
            List<Booking> bookedDetails = dbUtil.getBookingDetails(idbooking);
            request.setAttribute("bookedDetails", bookedDetails);

            RequestDispatcher dispatcher = request.getRequestDispatcher("Booking.jsp");
            dispatcher.forward(request, response);
        }
    }
}
