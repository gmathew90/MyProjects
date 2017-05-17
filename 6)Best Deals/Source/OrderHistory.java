import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.sql.*;


public class OrderHistory extends HttpServlet
 {
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    PrintWriter out = response.getWriter();
  int price=0;
int id=0;
String ad="";
String crdt="";


    HttpSession session = request.getSession(true);
   char a='0';
    String welcm="";
   String type="";
    String name=(String)session.getAttribute("username");


    try{
    a=name.charAt(0);
    }
    catch (NullPointerException n)
	{
	}
    if (a!='1'){
    welcm="Please Log In";
    }
    else{

    String[] parts=name.split("_");
    name=parts[1];
    type=parts[2];
    }



 Connection conn=null;
out.println("<!doctype html>");
out.println("<html>");
out.println("<head>");
out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
out.println("<title>BestDeal</title>");

out.println("<link rel=\"stylesheet\" href=\"http://localhost/csj/styles_custom.css\" type=\"text/css\" />");
out.println("<!--");
out.println("pied, a free CSS web template by ZyPOP (zypopwebtemplates.com/)");
out.println("");
out.println("Download: http://zypopwebtemplates.com/");
out.println("");
out.println("License: Creative Commons Attribution");
out.println("//-->");
out.println("<meta name=\"viewport\" content=\"width=device-width, minimum-scale=1.0, maximum-scale=1.0\" />");
out.println("</head>");
out.println("<body onload =\"init()\">");
out.println("<script type=\"text/javascript\" src=\"script.js\"></script>");


out.println("<div id=\"container\">");
out.println("  <header>");
out.println("	<div class=\"width\">");
out.println("		<h6>"+welcm+"</h6>");

out.println("  		  <ul>");
out.println("        		<li style=\"display:inline-block;\">");
out.println("    		<h1><a href=\"Contact.html\">BestDeal</a></h1>");
out.println("        		</li>");
out.println("        		<li style=\"display:inline-block; padding-left:500px\">");
out.println("<div name=\"autofillform\">");
out.println("<input type=\"text\" name=\"searchId\" class=\"input\" id=\"searchId\" placeholder=\"Search our products\" onkeyup=\"doCompletion()\" style=\"padding 5px; fontsize=16px;\"/>");
out.println("<div id=\"auto-row\">");
out.println("<table id=\"complete-table\" class=\"gridtable\" style=\"position:absolute; width=200px background-color=white;\"></table>");

out.println("</div>");
out.println("</div");
out.println("        		<li>");

out.println("       	</div>");
out.println("    </header>");
out.println("    <nav>");
out.println("	<div class=\"width\">");
out.println("  		  <ul>");
out.println("        		<li class=\"selected\"><a href=\"/csj/\">Home</a></li>");
out.println("        	    	<li class=\"start\"><a href=\"/csj/Login1\">Login</a></li>");
out.println("         	   	<li class=\"start\"><a href=\"/csj/Signup1\">Signup</a></li>");
out.println("          	 	<li class=\"end\"><a href=\"Contact.html\">Contact</a></li>");
out.println("         	   	<li class=\"start\"><a href=\"/csj/Cart\">Cart</a></li>");
out.println("         	   	<li class=\"start\"><a href=\"/csj/OrderHistory\">OrderHistory</a></li>");
out.println("         	   	<li class=\"start\"><a href=\"/csj/Trending\">Trending</a></li>");
out.println("         	   	<li class=\"start\"><a href=\"/csj/DataAnalytics\">DataAnalytics</a></li>");
if (type.equals("StoreManager"))
{
out.println("          	 	<li class=\"end\"><a href=\"/csj/Update1\">Update Products</a></li>");
}
if (type.equals("Salesman"))
{
out.println("          	 	<li class=\"end\"><a href=\"/csj/CustUpdate1\">Update Customers</a></li>");
out.println("          	 	<li class=\"end\"><a href=\"/csj/OrderUpdate\">Update Orders</a></li>");
}

out.println("        	</ul>");
out.println("	</div>");
out.println("    </nav>");
out.println("");
out.println("    <div id=\"body\" class=\"width\">");
out.println("		");
out.println("        <section id=\"content\">");
out.println("");
out.println("	    <article>");
out.println("	    ");
out.println("");

out.println("            ");


out.println("            <table style=\"width:100%\">");
out.println("<tr><td>");
out.println("            <h5><td>"+"ID"+"</td></h5>");
out.println("            <h5><td>"+"Amount"+"</td></h5>");
out.println("            <h5><td>"+"Address"+"</td></h5>");
out.println("            <h5><td>"+"DeliveryDate"+"</td></h5>");
try{
MySQLDataStoreUtilities ms=new MySQLDataStoreUtilities();

ResultSet rs = ms.orderHistory(name);

while(rs.next()) {
id=rs.getInt("OrderId");
price=rs.getInt("orderPrice");
ad=rs.getString("UserAddress");
crdt=rs.getString("creditCardNo");
 out.println("<tr>");
     		if (1==1){
out.println("                <form name=\"Login\" method=\"POST\" action=\"/csj/OrderDelete\">");
out.println("            <h5><td>"+" "+"</td></h5>");
out.println("            <h5><td>"+id+"</td></h5>");
out.println("            <h5><td>"+price+"</td></h5>");
out.println("            <h5><td>"+ad+"</td></h5>");
out.println("            <h5><td>"+rs.getString("buydate")+"</td></h5>");

out.println("                    <td><input name=\"id\" id=\"id\" value="+id+" type=\"hidden\" /></td></p>");
out.println("                    <td><input name=\"typ\" id=\"typ\" value="+"orderHistory"+" type=\"hidden\" /></td></p>");
out.println("                    <td><p><input name=\"send\" style=\"margin-left: 150px;\" class=\"formbutton\" value=\"Cancel\" type=\"submit\" /></td></p>");
out.println("</tr>");
out.println("                </form>");
}
}
}
catch(Exception e)
{
}
out.println("            </table>");
out.println("            ");

out.println("            ");
out.println("            ");
out.println("      		</article>");
out.println("        </section>");
out.println("        ");
out.println("        <aside class=\"sidebar\">");
out.println("");
out.println("           <ul>	");
out.println("               <li>");
out.println("                    <h4>Categories</h4>");
out.println("                    <ul>");
out.println("                        <li><a href=\"/csj/SmartPhones\">Smart Phones</a></li>");
out.println("                        <li><a href=\"/csj/Tablets\">Tablets</a></li>");
out.println("                        <li><a href=\"/csj/Laptops\">Laptops</a></li>");
out.println("                        <li><a href=\"/csj/TV\">TV</a></li>");
out.println("                       ");
out.println("                    </ul>");
out.println("                </li>");
out.println("                ");
out.println("               ");
out.println("                ");
out.println("                ");
out.println("                ");
out.println("                ");
out.println("                ");
out.println("            </ul>");
out.println("		");
out.println("        </aside>");
out.println("    	<div class=\"clear\"></div>");
out.println("    </div>");
out.println("    <footer>");
out.println("        <div class=\"footer-content width\">");
out.println("            <ul>");
out.println("            	<li><a href=\"#\">Return Policy</a></li>");
out.println("                ");
out.println("            </ul>");
out.println("            ");
out.println("            <ul>");
out.println("            	<li><a href=\"#\">Warranty</a></li>");
out.println("                ");
out.println("            </ul>");
out.println("            ");
out.println("            <ul class=\"endfooter\">");
out.println("		");
out.println("            	<li><a href=\"#\">Support and Services</a></li>");
out.println("                ");
out.println("            </ul>");
out.println("            ");
out.println("            <div class=\"clear\"></div>");
out.println("        </div>");
out.println("        <div class=\"footer-bottom\">");
out.println("            <p> <a href=\"http://georgemathewweb.com/\">Developed by George Mathew</a> </p>");
out.println("         </div>");
out.println("    </footer>");
out.println("</div>");
out.println("</body>");
out.println("</html>");
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
