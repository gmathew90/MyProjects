import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;

public class OrderDelete extends HttpServlet {
  public void processRequest(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");

    HttpSession session = request.getSession(true);
    PrintWriter out = response.getWriter();
    String id = request.getParameter("id");
    String typ=request.getParameter("typ");
   Connection conn=null;
   try{
     Class.forName("com.mysql.jdbc.Driver").newInstance();
    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdeals?useSSL=true","root","root");

    conn.createStatement().executeUpdate("Delete from CustomerOrders where OrderId=\""+id+"\"");
    conn.createStatement().executeUpdate("Delete from ProductSales where OrderId=\""+id+"\"");
    out.println("Query Excecuted");


}
catch (Exception e){


}
if (typ.equals("orderHistory"))
{
response.sendRedirect(request.getContextPath() + "/OrderHistory");
}
else{
  response.sendRedirect(request.getContextPath() + "/OrderUpdate");
}
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
