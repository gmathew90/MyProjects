import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;



public class autocomplete extends HttpServlet {
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {


    //session.setAttribute("username", "1_"+name+"_"+usertype);

    //response.sendRedirect(request.getContextPath() + "");
  }

protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        String action = request.getParameter("action");
        String searchId = request.getParameter("searchId");
        try
    {
    StringBuffer sb = new StringBuffer();
    boolean namesAdded = false;
    if (action.equals("complete"))
    {
    if (!searchId.equals(""))
    {
    AjaxUtility a=new AjaxUtility();
    sb=a.readData(searchId);
    if(sb!=null || !sb.equals(""))
    {
    namesAdded=true;
    }
    if (namesAdded)
    {

    //response.getWriter().write("<products>" + sb.toString() + "</products>");
    response.getWriter().write("<products>"+sb.toString()+"</products>");
    //response.getWriter().write("<products><product><id>1</id><productName>"+action+"</productName></product></products>");
    }
    }
    }
  }
  catch(Exception e)
  {

  }
    //response.getWriter().write("<products><product><id>1</id><productName>"+action+"</productName></product></products>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }
}
