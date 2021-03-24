import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DeleteCookie extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Cookie cookies[] = request.getCookies();
        
        for(Cookie cookie:cookies){
            Cookie c = new Cookie(cookie.getName(),"");
            c.setMaxAge(0);
            response.addCookie(c);
        }
        
        out.println("All Cookies are deleted.");
    }
}