import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;



public class start extends HttpServlet {
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
HttpSession session = request.getSession(true);
    PrintWriter out = response.getWriter();
    
    MySQLDataStoreUtilities MS= new MySQLDataStoreUtilities();
MS.Deleteproducts();
SaxParser4GameSpeedXMLdataStore sx= new SaxParser4GameSpeedXMLdataStore("SmartPhones_Items.xml");

for (item it: sx.items) {

MS.ProductsUpdate(it.id,it.name,it.image,it.retailer,it.condition,it.price,"Smartphones");
}
sx= new SaxParser4GameSpeedXMLdataStore("Laptops_Items.xml");
for (item it: sx.items) {
MS.ProductsUpdate(it.id,it.name,it.image,it.retailer,it.condition,it.price,"Laptops");
}
sx= new SaxParser4GameSpeedXMLdataStore("Tablets_Items.xml");
for (item it: sx.items) {
MS.ProductsUpdate(it.id,it.name,it.image,it.retailer,it.condition,it.price,"Tablets");
}
sx= new SaxParser4GameSpeedXMLdataStore("TV_Items.xml");
for (item it: sx.items) {
MS.ProductsUpdate(it.id,it.name,it.image,it.retailer,it.condition,it.price,"TV");
}
response.sendRedirect(request.getContextPath() + "/Home");

}


    //session.setAttribute("username", "1_"+name+"_"+usertype);

    //response.sendRedirect(request.getContextPath() + "");


protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }
}
