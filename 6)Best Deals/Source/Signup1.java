import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Signup1 extends HttpServlet {
  public void processRequest(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");

    HttpSession session = request.getSession(true);
    PrintWriter out = response.getWriter();

    String errorMsg=(String)session.getAttribute("errorMsg");



    out.println("<!doctype html>");
out.println("<html>");
out.println("<head>");
out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
out.println("<title>BestDeal</title>");
out.println("<link rel=\"stylesheet\" href=\"http://localhost/csj/styles_custom.css\" type=\"text/css\" />");
out.println(">");
out.println("<meta name=\"viewport\" content=\"width=device-width, minimum-scale=1.0, maximum-scale=1.0\" />");
out.println("</head>");
out.println("<body>");
out.println("<div id=\"container\">");
out.println("  <header>");
out.println("	<div class=\"width\">");
out.println("		<h6>Please Log in</h6>");
out.println("    		<h1><a href=\"Contact.html\">BestDeal</a></h1>");
out.println("       	</div>");
out.println("    </header>");
out.println("    <nav>");
out.println("	<div class=\"width\">");
out.println("  		  <ul>");
out.println("        		<li class=\"selected\"><a href=\"/csj/\">Home</a></li>");
out.println("        	    	<li class=\"start\"><a href=\"/csj/Login1\">Login</a></li>");
out.println("         	   	<li class=\"selected\"><a href=\"/csj/Signup1\">Signup</a></li>");
out.println("          	 	<li class=\"end\"><a href=\"Contact.html\">Contact</a></li>");
out.println("         	   	<li class=\"start\"><a href=\"/csj/Cart\">Cart</a></li>");
out.println("         	   	<li class=\"start\"><a href=\"/csj/OrderHistory\">OrderHistory</a></li>");
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
out.println("            <h3>Signup</h3>");
try{
if(!errorMsg.equals("null")){
out.println("            <h3>"+errorMsg+"</h3>");}
}
catch(Exception e)
{
}
session.setAttribute("errorMsg", "");
out.println("");
out.println("            <fieldset>");
out.println("                <legend>Please Fill in the Details</legend>");
out.println("                <form name=\"Login\" method=\"POST\" action=\"/csj/Signup\">");
out.println("		    <select name=\"usertype\" >");
out.println("					<option value=\"Customer\">Customer</option>");
out.println("					<option value=\"StoreManager\">StoreManager</option>");
out.println("					<option value=\"Salesman\">SalesMan</option>");
out.println("			</select>");
out.println("                    <p><label for=\"name\">Username:</label>");
out.println("                    <input name=\"name\" id=\"name\" value=\"Username\" type=\"text\" /></p>");
out.println("                    ");
out.println("		    <p><label for=\"pass\">Password:</label>");
out.println("                    <input name=\"pass\" id=\"pass\" value=\"12345678\" type=\"password\" /></p>");
out.println("                    <p><label for=\"pass2\">Retype Password:</label>");
out.println("                    <input name=\"pass2\" id=\"pass2\" value=\"12345678\" type=\"password\" /></p>");
out.println("                    <p><input name=\"send\" style=\"margin-left: 150px;\" class=\"formbutton\" value=\"submit\" type=\"submit\" /></p>");
out.println("                </form>");
out.println("            </fieldset>");
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
