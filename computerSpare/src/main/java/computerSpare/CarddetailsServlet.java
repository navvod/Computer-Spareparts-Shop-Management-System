package computerSpare;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class CarddetailsServlet
 */
@WebServlet("/CarddetailsServlet") // Annotation for servlet mapping
public class CarddetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor
     */
    public CarddetailsServlet() {
        super();
    }

    /**
     * Handling HTTP GET requests
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Creating an instance of the interface using polymorphism
        iCustomerDButil customerDBUtil = new CustomerDBUtil();

        // Retrieving card details for the current customer using polymorphism
        List<Card> cardDetails = customerDBUtil.getCard(CustomerDBUtil.cusID);

        // Setting the card details as an attribute in the request encapsulating data
        request.setAttribute("cardDetails", cardDetails);

        // Forwarding the request to the "dopay.jsp" page for display using encapsulation
        RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/dopay.jsp");
        dispatcher1.forward(request, response);
    }
}
