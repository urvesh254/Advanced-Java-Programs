
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class Cart extends HttpServlet
{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        boolean iPhone = (Boolean) session.getAttribute("iphone");
        boolean iPad = (Boolean) session.getAttribute("ipad");
        boolean macbook = (Boolean) session.getAttribute("macbook");

        if (!(iPhone || iPad || macbook)) {
            out.print("Your cart is empty.");
        }
        else {
            out.println("<h2>Your Cart :</h2> <br>");
            if (iPhone) {
                out.println("- iPhone 12 pro blue hero<br>");
            }
            if (iPad) {
                out.println("- Apple iPad Pro <br>");
            }
            if (macbook) {
                out.println("- MacBook Pro - Space Gray <br>");
            }
        }

        out.println("<br>");
        out.println("<br>");
        out.println("<br>");
        out.println("<a href=\"index.html\"><button>Log Out</button></a>");
    }
}
