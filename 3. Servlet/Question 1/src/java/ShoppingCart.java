
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ShoppingCart extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String iPhoneString = request.getParameter("iphone");
        String iPadString = request.getParameter("ipad");
        String macBookString = request.getParameter("macbook");

        boolean iPhone = iPhoneString == null ? false : true;
        boolean iPad = iPadString == null ? false : true;
        boolean macbook = macBookString == null ? false : true;

        if (!(iPhone || iPad || macbook)) {
            out.print("Your cart is empty.");
        }
        else {
            out.println("<h2>Selected Items :</h2> <br>");
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
