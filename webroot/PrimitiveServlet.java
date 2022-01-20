import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class PrimitiveServlet implements Servlet {

  public void init(ServletConfig config) throws ServletException {
    System.out.println("init");
  }

  public void service(ServletRequest request, ServletResponse response)
    throws ServletException, IOException {
    System.out.println("from service");
        PrintWriter out = response.getWriter();
        int length = "Hello. Roses are red.\r\n\r\n".length()+"Violets are blue?".length();
        String headMessage = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: "+length+"\r\n" +
                "\r\n";
        out.print(headMessage);
        out.println("Hello. Roses are red.");
        out.println("Violets are blue?");
  }

  public void destroy() {
    System.out.println("destroy");
  }

  public String getServletInfo() {
    return null;
  }
  public ServletConfig getServletConfig() {
    return null;
  }

}
