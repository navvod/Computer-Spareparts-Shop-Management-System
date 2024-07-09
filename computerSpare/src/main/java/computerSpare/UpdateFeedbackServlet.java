// UpdateFeedbackServlet.java

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
 * Servlet implementation class UpdateFeedbackServlet
 * This servlet handles updating feedback information.
 */
@WebServlet("/UpdateFeedbackServlet")
public class UpdateFeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles HTTP POST requests for updating feedback information.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve parameters from the request
        String idbooking = request.getParameter("idbooking");
        String date = request.getParameter("date");
        String name = request.getParameter("name");
        String feedbacks = request.getParameter("feedbacks");

        // Flag to check if the update was successful
        boolean isUpdateSuccessful;

        // Create an instance of the interface using polymorphism
        iCustomerDButil dbUtil = new CustomerDBUtil();

        // Update the feedback information in the database
        isUpdateSuccessful = dbUtil.updatefeedback(idbooking, date, name, feedbacks);

        if (isUpdateSuccessful) {
            // Retrieve updated feedback details for display
            List<Feedback> feedbackDetails = dbUtil.getfeedbackDetails(idbooking);
            request.setAttribute("feedbackDetails", feedbackDetails);

            // Forward the request and response to the FeedbackView.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("FeedbackView.jsp");
            dispatcher.forward(request, response);
        }
    }
}
