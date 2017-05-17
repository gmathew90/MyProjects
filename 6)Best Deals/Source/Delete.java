import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Delete extends HttpServlet {
  public void processRequest(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html"); 
    
    HttpSession session = request.getSession(true);
    PrintWriter out = response.getWriter();
    String id = request.getParameter("id");
     HashMap<String, ArrayList<String>> hm1=new HashMap<String, ArrayList<String>>();
    ArrayList<String> list = new ArrayList<String>();
       try{
   	FileInputStream fileInputStream = new FileInputStream(new File("Orders.txt"));
   	ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
    
   	hm1= (HashMap)objectInputStream.readObject();
	hm1.remove(id);
FileOutputStream fileOutputStream = new FileOutputStream("Orders.txt");
     ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
     objectOutputStream.writeObject(hm1);
     objectOutputStream.flush();
     objectOutputStream.close();
      fileOutputStream.close();
    }
    catch (Exception e)
{
}
response.sendRedirect(request.getContextPath() + "/OrderHistory");
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
