import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class CartUpdate extends HttpServlet {
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    PrintWriter out = response.getWriter();
    String usertype = request.getParameter("usertype");
    String name = request.getParameter("name");
    String price = request.getParameter("price");
    String cond=request.getParameter("condition");
    HashMap<String, String> hm=new HashMap<String, String>();
    int errFlg=0;
    int nuflg=0;
    HttpSession session = request.getSession(true);
    String errorMsg ="";
   Connection conn = null;








try{

    MySQLDataStoreUtilities MS = new MySQLDataStoreUtilities();
    MS.CartUpdate(name,cond,price);



}
catch (Exception e){


}



    response.sendRedirect(request.getContextPath() + "/Cart");



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
