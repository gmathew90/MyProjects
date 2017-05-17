import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Signup extends HttpServlet {
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    PrintWriter out = response.getWriter();
    String usertype = request.getParameter("usertype");
    String name = request.getParameter("name");
    String pass = request.getParameter("pass");
    String pass2=request.getParameter("pass2");
    HashMap<String, String> hm=new HashMap<String, String>();
    int errFlg=0;
    int nuflg=0;
    HttpSession session = request.getSession(true);
    String errorMsg ="";
   MySQLDataStoreUtilities MS=new MySQLDataStoreUtilities();
try{

ResultSet rs=MS.login(name);
while(rs.next()){
nuflg++;

}
if (nuflg!=0)
{
errorMsg =errorMsg+ "Username already exist";
      			errFlg=1;
}
}
catch (Exception e)
{

}






    if (errFlg==0){
          if(pass.equals(pass2)) {
    			errFlg=0;
    				}
    		else
    		{
     		errorMsg=errorMsg+"Password Doesnt Match";
     		errFlg=1;
    		}
	}



    if (errFlg==0)
    {
    MS.signup(name,pass,usertype);
    errorMsg=errorMsg+"User Created";




     }
    session.setAttribute("errorMsg", errorMsg);

    response.sendRedirect(request.getContextPath() + "/Signup1");



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
