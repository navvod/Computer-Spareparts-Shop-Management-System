package computerSpare;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet implementation class CardinsertServlet
 */
@WebServlet("/CardinsertServlet") // Annotation for servlet mapping
public class CardinsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor
     */
    public CardinsertServlet() {
        super();
    }

    /**
     * Handling HTTP POST requests for inserting card details
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieving card details from the form parameters
        String card_number = request.getParameter("card_number");
        String cardholder_name = request.getParameter("cardholder_name");
        String CVC = request.getParameter("CVC");
        String expiry_date = request.getParameter("expiry_date");

        // Variable to catch the output value from the return value from dbutil
        boolean isTrue;

        // Creating an instance of the interface using polymorphism
        iCustomerDButil customerDBUtil = new CustomerDBUtil();

        // Inserting card details into the database using polymorphism
        isTrue = customerDBUtil.insertcard(card_number, cardholder_name, CVC, expiry_date);

        // Redirecting based on the success of the card insertion using encapsulation
        if (isTrue) {
            // Successful insertion, forwarding to "frontmain.jsp"
            RequestDispatcher dis = request.getRequestDispatcher("frontmain.jsp");
            dis.forward(request, response);
        } else {
            // Unsuccessful insertion, forwarding to an error page (you might want to replace "#")
            RequestDispatcher dis2 = request.getRequestDispatcher("#");
            dis2.forward(request, response);
        }
    }
}
