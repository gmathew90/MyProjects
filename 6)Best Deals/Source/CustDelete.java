import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;

public class CustDelete extends HttpServlet {
  public void processRequest(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");

    HttpSession session = request.getSession(true);
    PrintWriter out = response.getWriter();
    String id = request.getParameter("id");
   MySQLDataStoreUtilities Ms= new MySQLDataStoreUtilities();
   Ms.DeleteRegi(id);
response.sendRedirect(request.getContextPath() + "/CustUpdate1");
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
