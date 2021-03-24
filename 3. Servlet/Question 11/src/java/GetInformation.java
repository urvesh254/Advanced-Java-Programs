
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class GetInformation extends HttpServlet
{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // getHeader("host") return ipaddress:port.
        // ex. 127.0.0.1:8888
        String IpInfo[] = request.getHeader("host").split(":");

        out.println("1. Client Browser : " + request.getHeader("user-agent"));
        out.println("<br>");
        out.println("2. Client IP address : " + IpInfo[0]);
        out.println("<br>");
        out.println("3. Client Port No : " + IpInfo[1]);
        out.println("<br>");
        out.println("4. Server Port No : " + request.getServerPort());
        out.println("<br>");
        out.println("5. Local Port No : " + request.getLocalPort());
        out.println("<br>");
        out.println("6. Method used by client for form submission : " + request.getMethod());
        out.println("<br>");
        out.println("7. Query String name and values : " + request.getQueryString());
        out.println("<br>");
    }
}
