import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;
import java.util.Date;

public class ReviewUpdate1 extends HttpServlet {
  public void processRequest(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");

    HttpSession session = request.getSession(true);
    PrintWriter out = response.getWriter();
    String Rating = request.getParameter("Rating");
    String ReviewText=request.getParameter("Review");
    String type = request.getParameter("type");
    String username=request.getParameter("username");
    String name = request.getParameter("name");
    String price = request.getParameter("price");
    String age = request.getParameter("age");
    String gender = request.getParameter("gender");
    String occupation = request.getParameter("occupation");
    Date date = new Date();
    String Redir="";
    MongoDBDataStoreUtilities mn= new MongoDBDataStoreUtilities();
    mn.storeReview(name,username,type,Rating,date.toString(),ReviewText,"BestDeals",price,"BestDeals","Chicago","60616","IL","yes","yes",age,gender,occupation);
    if (type.equals("Smartphones")){
      Redir="/SmartPhones";
    }
    if (type.equals("TV")){
      Redir="/TV";
    }
    if (type.equals("Laptops")){
      Redir="/Laptops";
    }
    if (type.equals("Tablets")){
      Redir="/Tablets";
    }





    response.sendRedirect(request.getContextPath() + Redir);
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
