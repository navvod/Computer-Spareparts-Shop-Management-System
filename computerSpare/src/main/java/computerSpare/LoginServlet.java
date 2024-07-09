// LoginServlet.java

package computerSpare;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class LoginServlet
 * This servlet handles user login and redirects to appropriate pages.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static boolean isUserValid;
    private static String username;

    /**
     * Handles HTTP POST requests for user login.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Get user input from the login form
        String userName = request.getParameter("uid");
        String password = request.getParameter("pass");
        username = userName;

        // Create an instance of the interface using polymorphism
        iCustomerDButil dbUtil = new CustomerDBUtil();

        // Validate user credentials
        isUserValid = dbUtil.validate(userName, password);

        if (isUserValid) {
            // Redirect to the main page after successful login
            RequestDispatcher dispatcher = request.getRequestDispatcher("frontmain.jsp");
            dispatcher.forward(request, response);
        } else {
            // Display an alert for incorrect username or password
            out.println("<script type='text/javascript'>");
            out.println("alert('Your username or password is incorrect');");
            out.println("location='login.jsp'");
            out.println("</script>");
        }
    }

    /**
     * Handles HTTP GET requests.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check if the user is logged in before processing GET requests
        if (isUserValid) {
            // Retrieve customer details for the logged-in user
            iCustomerDButil dbUtil = new CustomerDBUtil();
            List<Customer> cusDetails = dbUtil.getCustomer(username);
            request.setAttribute("cusDetails", cusDetails);

            // Forward the request and response to the my-account.jsp page
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/my-account.jsp");
            dispatcher.forward(request, response);
        }
    }
}
