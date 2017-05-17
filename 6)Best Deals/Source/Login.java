import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;



public class Login extends HttpServlet {
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    PrintWriter out = response.getWriter();
    String usertype ="";
    String name = request.getParameter("name");
    String pass = request.getParameter("pass");
    String pass1="";
    HttpSession session = request.getSession(true);
    int flg=0;
    String errorMsg ="";
    MySQLDataStoreUtilities MS= new MySQLDataStoreUtilities();
try{
     ResultSet rs = MS.login(name);

     while(rs.next()){

	pass1=rs.getString("password");
	if (pass.equals(pass1)){
	flg=1;
	usertype=rs.getString("usertype");
	}
        }
}
catch (Exception e)
{}


    if (flg==0){
	errorMsg ="Username doesnt exist or Password Doesnt Match ";
        session.setAttribute("errorMsg", errorMsg);

    response.sendRedirect(request.getContextPath() + "/Login1");
	}
	else
	{
errorMsg="null";
session.setAttribute("errorMsg", errorMsg);
session.setAttribute("username", "1_"+name+"_"+usertype);
response.sendRedirect(request.getContextPath() + "/Home");

}


    //session.setAttribute("username", "1_"+name+"_"+usertype);

    //response.sendRedirect(request.getContextPath() + "");
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
