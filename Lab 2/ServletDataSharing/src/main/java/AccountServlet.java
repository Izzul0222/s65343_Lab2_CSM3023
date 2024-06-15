import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class AccountServlet extends HttpServlet {

    HashMap<String, String[]> account = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        account.put("Ali", new String[]{"31/01/2019: 2000.00", "28/02/2019: 3000.00"});
        account.put("Ahmad", new String[]{"31/01/2019: 100.00", "28/02/2019: 5000.00"});
        account.put("Muthu", new String[]{"31/01/2019: 1000.00", "28/02/2019: 2000.00"});
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String userid_login = (String) request.getAttribute("userid");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AccountServlet</title>");
            out.println("</head>");
            out.println("<body>");

            if (account.get(userid_login) == null) {
                out.println("<h1>Sorry, no information found!</h1>");
            } else {
                out.println("<h1>Account status for: " + userid_login + "</h1>");
                for (String tempAcc : account.get(userid_login)) {
                    out.println("<h2>" + tempAcc + "</h2>");
                }
            }

            out.println("</body>");
            out.println("</html>");
        }
    }
}
