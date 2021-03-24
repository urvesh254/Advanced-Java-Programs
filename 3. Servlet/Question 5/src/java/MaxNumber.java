
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class MaxNumber extends HttpServlet
{

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));

        out.println("Num1 : " + num1 + "<br/>  Num2 : " + num2);
        out.println("<br/>");
        out.println("<br/>");

        if (num1 > num2) {
            out.println("Max Number : " + num1);
        }
        else {
            out.println("Max Number : " + num2);
        }
    }
}
