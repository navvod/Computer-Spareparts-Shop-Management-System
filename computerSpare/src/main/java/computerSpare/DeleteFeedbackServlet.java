// DeleteFeedbackServlet.java

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
 * Servlet implementation class DeleteFeedbackServlet
 * This servlet handles the deletion of feedback.
 */
@WebServlet("/DeleteFeedbackServlet")
public class DeleteFeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles HTTP POST requests for deleting feedback.
     * Uses the iCustomerDButil interface to interact with the database.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the feedback ID parameter from the request
        String feedbackID = request.getParameter("idbooking");
        boolean isDeletionSuccessful;

        // Create an instance of the interface using polymorphism
        iCustomerDButil dbUtil = new CustomerDBUtil();

        // Delete the feedback and capture the result
        isDeletionSuccessful = dbUtil.deletefeedback(feedbackID);

        if (isDeletionSuccessful) {
            // Successful deletion, navigate to the frontmain.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("frontmain.jsp");
            dispatcher.forward(request, response);
        } else {
            // Unsuccessful deletion, retrieve feedback details and forward to the Feedback.jsp for further action
            List<Feedback> feedbackDetails = dbUtil.getfeedbackDetails(feedbackID);
            request.setAttribute("feedbackDetails", feedbackDetails);

            RequestDispatcher dispatcher = request.getRequestDispatcher("Feedback.jsp");
            dispatcher.forward(request, response);
        }
    }
}
