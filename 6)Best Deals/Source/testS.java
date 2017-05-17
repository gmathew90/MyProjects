import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import java.sql.*;

public class testS extends HttpServlet {
public void processRequest(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
  /*  response.setContentType("text/html");
PrintWriter out = response.getWriter();
AjaxUtility a=new AjaxUtility();
  StringBuffer sb = new StringBuffer();
sb=a.readData("N");
out.println(sb);*/



}
protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
      String action = request.getParameter("action");
      String searchId = request.getParameter("searchId");
      PrintWriter out = response.getWriter();
      out.println(action);
      out.println(searchId);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }


}
