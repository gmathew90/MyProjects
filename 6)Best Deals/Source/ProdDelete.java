import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;

public class ProdDelete extends HttpServlet {
  public void processRequest(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");

    HttpSession session = request.getSession(true);
    PrintWriter out = response.getWriter();
    String id = request.getParameter("id");
    String type = request.getParameter("type");
    String Redir="";
   MySQLDataStoreUtilities Ms= new MySQLDataStoreUtilities();
   Ms.ProdDelete(id);
   if (type.equals("Smartphones")){
     Redir="/SmartPhones";
   }
   if (type.equals("TV")){
     Redir="/TV";
   }
   if (type.equals("Laptops")){
     Redir="/Laptops";
   }
   if (type.equals("Tablets")){
     Redir="/Tablets";
   }





   response.sendRedirect(request.getContextPath() + Redir);
  }

protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }
}
