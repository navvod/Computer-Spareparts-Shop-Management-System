// FeedbackdetailsServlet.java

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
 * Servlet implementation class FeedbackdetailsServlet
 * This servlet retrieves and forwards feedback details to the FeedbackView.jsp page.
 */
@WebServlet("/FeedbackdetailsServlet")
public class FeedbackdetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles HTTP GET requests for retrieving and displaying feedback details.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Initialize response writer and set content type
        response.getWriter();
        response.setContentType("text/html");

        // Create an instance of the interface using polymorphism
        iCustomerDButil dbUtil = new CustomerDBUtil();

        // Retrieve feedback details for the specified customer ID
        List<Feedback> feedbackDetails = dbUtil.getfeedback(CustomerDBUtil.cusID);
        request.setAttribute("feedbackDetails", feedbackDetails);

        // Forward the request and response to the FeedbackView.jsp page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FeedbackView.jsp");
        dispatcher.forward(request, response);
    }
}
