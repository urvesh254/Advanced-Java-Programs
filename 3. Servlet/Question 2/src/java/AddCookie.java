import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class AddCookie extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
     
        Cookie nameCookie = new Cookie("name",name);
        Cookie surnameCookie = new Cookie("surname",surname);
        
        response.addCookie(nameCookie);
        response.addCookie(surnameCookie);
     
        out.println("Cookie added with value name and surname.");
    }
}