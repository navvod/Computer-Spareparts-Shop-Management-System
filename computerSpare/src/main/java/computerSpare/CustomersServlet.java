package computerSpare;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class CustomersServlet
 */
@WebServlet("/CustomersServlet") // Annotation for servlet mapping
public class CustomersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handling HTTP POST requests for customer registration
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Retrieving customer registration details from the form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("uid");
        String password = request.getParameter("psw");

        // Variable to catch the output value from the return value from dbutil
        boolean isTrue;

        // Creating an instance of the interface using polymorphism
        iCustomerDButil customerDBUtil = new CustomerDBUtil();

        // Inserting customer registration details into the database using polymorphism
        isTrue = customerDBUtil.insertcustomer(name, phone, email, username, password);

        // Redirecting based on the success of the customer registration using encapsulation
        if (isTrue) {
            // Successful registration, forwarding to "login.jsp"
            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
            dis.forward(request, response);
        } else {
            // Unsuccessful registration, forwarding to "index.html" (you might want to handle errors more effectively)
            RequestDispatcher dis2 = request.getRequestDispatcher("index.html");
            dis2.forward(request, response);
        }
    }
}
