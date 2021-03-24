import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ReadCookie extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            out.println("Cookies:<br/>");
            for (Cookie cookie : cookies) {
                out.println("Name : " + cookie.getName() + ", Value : " + cookie.getValue());
                out.println("<br/>");
            }
        }
        else {
            out.println("No cookies found.");
        }
    }
}