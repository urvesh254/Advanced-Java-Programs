
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Shopping extends HttpServlet
{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        shoppingElements(out, username);

    }

    private void shoppingElements(PrintWriter out, String username) {
        String shoppingHtml = "<html>\n"
                + "    <head>\n"
                + "        <title>Shopping | Question 1</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <h1>Online Shopping</h1>\n"
                + "        <form action=\"ShoppingCart\" method=\"POST\">\n"
                + "            <label for=\"iphone\">\n"
                + "                <img src=\"iphone-12-pro-blue-hero.jpg\" width=250px alt=\"iPhone 12\" />\n"
                + "                <br>iPhone 12 pro blue hero\n"
                + "            </label>\n"
                + "            <input type=\"checkbox\" id=\"iphone\" name=\"iphone12\">\n"
                + "\n"
                + "            <br>\n"
                + "            <br>\n"
                + "\n"
                + "            <label for=\"ipad\">\n"
                + "                <img src=\"Apple iPad Pro.jpg\" width=250px alt=\"iPad Pro\" />\n"
                + "                <br>Apple iPad Pro\n"
                + "            </label>\n"
                + "            <input type=\"checkbox\" id=\"ipad\" name=\"ipad\">\n"
                + "\n"
                + "            <br>\n"
                + "            <br>\n"
                + "\n"
                + "            <label for=\"macbook\">\n"
                + "                <img src=\"MacBook Pro - Space Gray.jpg\" width=250px alt=\"iPhone 12\" />\n"
                + "                <br>MacBook Pro - Space Gray\n"
                + "            </label>\n"
                + "            <input type=\"checkbox\" id=\"macbook\" name=\"macbook\">\n"
                + "\n"
                + "            <br>\n"
                + "            <br>\n"
                + "            <br>\n"
                + "            <br>\n"
                + "            <br>\n"
                + "            <input type=\"submit\" value=\"Checkout\">\n"
                + "        </form>\n"
                + "    </body>\n"
                + "</html>\n"
                + "";
        try (BufferedReader br = new BufferedReader(new FileReader("shopping.html"))) {
            String s;
            while ((s = br.readLine()) != null) {
                out.println(s);
            }
        }
        catch (Exception e) {
            out.println(e.getMessage());
        }
    }
}
