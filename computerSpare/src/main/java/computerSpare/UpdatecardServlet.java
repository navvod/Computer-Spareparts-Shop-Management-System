// UpdatecardServlet.java

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
 * Servlet implementation class UpdatecardServlet
 * This servlet handles updating card information.
 */
@WebServlet("/UpdatecardServlet")
public class UpdatecardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles HTTP POST requests for updating card information.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve parameters from the request
        String idcard = request.getParameter("idcard");
        String CardNumber = request.getParameter("CardNumber");
        String CardHolderName = request.getParameter("CardHolderName");
        String CVC = request.getParameter("CVC");
        String ExpiredDate = request.getParameter("ExpiredDate");

        // Flag to check if the update was successful
        boolean isUpdateSuccessful;

        // Create an instance of the interface using polymorphism
        iCustomerDButil dbUtil = new CustomerDBUtil();

        // Update the card information in the database
        isUpdateSuccessful = dbUtil.updatecard(idcard, CardNumber, CardHolderName, CVC, ExpiredDate);

        if (isUpdateSuccessful) {
            // Retrieve updated card details for display
            List<Card> cardDetails = dbUtil.getCardDetails(idcard);
            request.setAttribute("cardDetails", cardDetails);

            // Forward the request and response to the dopay.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("dopay.jsp");
            dispatcher.forward(request, response);
        }
        // Add handling for the case where the update is not successful if needed
    }
}
