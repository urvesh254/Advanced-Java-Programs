
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SumOfDigits extends HttpServlet
{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String number = request.getParameter("number");

        int sumOfDigits = 0;
        for (int i = 0; i < number.length(); i++) {
            int n = Integer.parseInt(number.charAt(i) + "");
            sumOfDigits += n;
        }

        out.println("Number : " + number);
        out.println("<br>");
        out.println("Sum of Digits : " + sumOfDigits);
    }
}
