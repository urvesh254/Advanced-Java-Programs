
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CountDigits extends HttpServlet
{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String number = request.getParameter("number");

        out.println("Number : " + number);
        out.println("<br>");
        out.println("No of digits : " + number.length());
    }
}
