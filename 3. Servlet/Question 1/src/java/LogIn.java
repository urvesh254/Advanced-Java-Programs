
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class LogIn extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.sendRedirect("shopping.html");

    }
}
