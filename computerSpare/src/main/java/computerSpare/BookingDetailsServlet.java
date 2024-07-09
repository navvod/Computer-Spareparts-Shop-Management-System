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
 * Servlet implementation class BookingDetailsServlet
 */
@WebServlet("/BookingDetailsServlet") // Annotation for servlet mapping
public class BookingDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handling HTTP GET requests using encapsulation and polymorphism
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter();
        response.setContentType("text/html");

        // Creating an instance of the interface using polymorphism
        iCustomerDButil customerDBUtil = new CustomerDBUtil();

        // Retrieving booking details for the current customer using polymorphism
        List<Booking> bookDetails = customerDBUtil.getBooking(CustomerDBUtil.cusID);

        // Setting the booking details as an attribute in the request encapsulating data
        request.setAttribute("bookDetails", bookDetails);

        // Forwarding the request to the BookingView.jsp page for display using encapsulation
        RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/BookingView.jsp");
        dispatcher1.forward(request, response);
    }
}
