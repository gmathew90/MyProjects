import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class Update extends HttpServlet {
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    PrintWriter out = response.getWriter();
    String product = request.getParameter("product");
HttpSession session = request.getSession(true);
String name = request.getParameter("name");
String cond = request.getParameter("cond");
String price=request.getParameter("price");
String retailer=request.getParameter("retailer");
String tg="";
String id="";
String errorMsg="";
MySQLDataStoreUtilities MS= new MySQLDataStoreUtilities();

try{

ResultSet rs=MS.productID(product);
while(rs.next())
{
id=rs.getString("id");

}
int b=(Character.getNumericValue(id.trim().charAt(1)));
tg=Character.toString(id.trim().charAt(0));
b++;
tg=tg+b;
MS.ProductsUpdate(tg,name,tg+".jpg",retailer,cond, Integer.parseInt(price),product);
errorMsg=tg+" product was added to the database";
}
catch(Exception e)
{}


    session.setAttribute("errorMsg", errorMsg);

    response.sendRedirect(request.getContextPath() + "/Update1");



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
