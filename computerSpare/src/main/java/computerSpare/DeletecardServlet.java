// DeletecardServlet.java

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
 * Servlet implementation class DeletecardServlet
 * This servlet handles the deletion of a card.
 */
@WebServlet("/DeletecardServlet")
public class DeletecardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles HTTP POST requests for deleting a card.
     * Uses the iCustomerDButil interface to interact with the database.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the idcard parameter from the request
        String idcard = request.getParameter("idcard");
        boolean isDeletionSuccessful;

        // Create an instance of the interface using polymorphism
        iCustomerDButil dbUtil = new CustomerDBUtil();

        // Delete the card and capture the result
        isDeletionSuccessful = dbUtil.deletecard(idcard);

        if (isDeletionSuccessful) {
            // Successful deletion, navigate to the main page
            RequestDispatcher dispatcher = request.getRequestDispatcher("frontmain.jsp");
            dispatcher.forward(request, response);
        } else {
            // Unsuccessful deletion, retrieve card details and forward to the dopay.jsp for further action
            List<Card> cardDetails = dbUtil.getCardDetails(idcard);
            request.setAttribute("cardDetails", cardDetails);

            RequestDispatcher dispatcher = request.getRequestDispatcher("dopay.jsp");
            dispatcher.forward(request, response);
        }
    }
}
