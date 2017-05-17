import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReviewUpdate extends HttpServlet {
  public void processRequest(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
   String id = request.getParameter("id");
   String nm=request.getParameter("name");
   String price=request.getParameter("price");
   String image=request.getParameter("image");
   String typ=request.getParameter("type");
    HttpSession session = request.getSession(true);
    PrintWriter out = response.getWriter();
    char a='0';
    String welcm="";
   String type="";
    String name=(String)session.getAttribute("username");
int flg=0;

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
    flg=1;
    String[] parts=name.split("_");
    name=parts[1];
    type=parts[2];



     welcm="Welcome "+name;
}



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
out.println("            <table style=\"width:100%\">");

out.println("            <tr><td>");
out.println("                <form name=\""+id+"\" method=\"POST\" action=\"/csj/ReviewUpdate1\">");
out.println("  		  <ul>");
out.println("            <img src=\""+ request.getContextPath()+"/images/" + image+"\"  style=\"width:200px;height:200px;\">");

out.println("        		<li >Item: "+nm+"</li>");

out.println("         	   	<li >Price: "+price+"</li>");

out.println("  		  <ul>");
out.println("                    <p><label for=\"key\"></label>");
out.println("<p><label for=\"Rating\">Age:</label>");
out.println("                    <input name=\"age\" id=\"age\" value=\"\" type=\"text\" /></p>");
out.println("                    ");
out.println("<p><label for=\"Rating\">Gender:</label>");
out.println("                    <input name=\"gender\" id=\"gender\" value=\"\" type=\"text\" /></p>");
out.println("                    ");
out.println("<p><label for=\"Rating\">Occupation:</label>");
out.println("                    <input name=\"occupation\" id=\"occupation\" value=\"\" type=\"text\" /></p>");
out.println("                    ");
out.println("<p><label for=\"Rating\">Retailer Name:</label>");
out.println("                    <input name=\"Retailer Name\" id=\"Retailer Name\" value=\"\" type=\"text\" /></p>");
out.println("                    ");
out.println("<p><label for=\"Rating\">Retailer zip:</label>");
out.println("                    <input name=\"Retailer zip\" id=\"Retailer zip\" value=\"\" type=\"text\" /></p>");
out.println("                    ");
out.println("<p><label for=\"Rating\">Retailer city:</label>");
out.println("                    <input name=\"Retailer city\" id=\"Retailer city\" value=\"\" type=\"text\" /></p>");
out.println("                    ");
out.println("<p><label for=\"Rating\">Retailer state:</label>");
out.println("                    <input name=\"Retailer state\" id=\"Retailer state\" value=\"\" type=\"text\" /></p>");
out.println("                    ");
out.println("<p><label for=\"Rating\">Product on Sale:</label>");
out.println("                    <input name=\"RProduct on Sale\" id=\"Product on Sale\" value=\"\" type=\"text\" /></p>");
out.println("                    ");
out.println("<p><label for=\"Rating\">Manufactor Name:</label>");
out.println("                    <input name=\"Manufacture Name\" id=\"Manufacture Name\" value=\"\" type=\"text\" /></p>");
out.println("                    ");
out.println("<p><label for=\"Rating\">Manufactor Rebate:</label>");
out.println("                    <input name=\"Manufacture Rebate\" id=\"Manufacture Rebate\" value=\"\" type=\"text\" /></p>");
out.println("                    ");
out.println("<p><label for=\"Rating\">Rating:</label>");
out.println("		    <select name=\"Rating\" >");
out.println("					<option value=\"1\">1</option>");
out.println("					<option value=\"2\">2</option>");
out.println("					<option value=\"3\">3</option>");
out.println("					<option value=\"4\">4</option>");
out.println("					<option value=\"5\">5</option>");
out.println("			</select>");
out.println("<p><label for=\"Review\">Review:</label>");

out.println("<textarea cols=\"37\" rows=\"11\" name=\"Review\" id=\"Review\"></textarea></p>");
out.println("                    <p><input name=\"send\" style=\"margin-left: 150px;\" class=\"formbutton\" value=\"Submit\" type=\"submit\" /></p>");
out.println("                    <input name=\"type\" id=\"type\" value="+typ+" type=\"hidden\" /></p>");
out.println("                    <input name=\"username\" id=\"username\" value="+name+" type=\"hidden\" /></p>");
out.println("                    <input name=\"name\" id=\"name\" value="+nm+" type=\"hidden\" /></p>");
out.println("                    <input name=\"price\" id=\"price\" value="+price+" type=\"hidden\" /></p>");
out.println("                </form>");

out.println("            </td></tr>");

out.println("            </table>");

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
