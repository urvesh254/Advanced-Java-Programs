
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class CalculateAreaOfcCircle extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        double radius = Double.parseDouble(request.getParameter("radius"));

        double area = Math.PI * radius * radius;

        out.println("Radius of Circle : " + radius);
        out.println("</br>");
        out.println("</br>");
        out.println("Area of Circle : " + area);
    }
}
