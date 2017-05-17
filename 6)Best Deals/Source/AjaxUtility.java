import java.util.*;
import java.io.*;
import java.sql.*;

public class AjaxUtility
{


  public static HashMap<String,product> getData()
  {
    MySQLDataStoreUtilities MS=new MySQLDataStoreUtilities();
    HashMap<String,product> hm=new HashMap<String,product>();

    ResultSet rs=null;
    try{
      Connection conn=MS.getConnection();
       rs = conn.createStatement().executeQuery("select * from products");
       while (rs.next())
       {
         hm.put(rs.getString("id"),new product(rs.getString("id"),rs.getString("nm")));
       }
    }
    catch (Exception e)
    {

    }
    return hm;

  }

public StringBuffer readData(String searchId)
{
  StringBuffer sb=new StringBuffer("");
  HashMap<String,product> data=getData();

Iterator it = data.entrySet().iterator();
while (it.hasNext())
{
Map.Entry pi = (Map.Entry)it.next();
product p=(product)pi.getValue();
if (p.productName.toLowerCase().startsWith(searchId.toLowerCase()))
{
sb.append("<product>");
sb.append("<id>" + p.productID + "</id>");
sb.append("<productName>" + p.productName + "</productName>");
sb.append("</product>");
}
}
return sb;
}

}
