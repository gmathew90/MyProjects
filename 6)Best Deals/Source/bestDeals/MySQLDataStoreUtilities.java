package bestDeals;
import java.util.*;
import java.sql.*;


public class MySQLDataStoreUtilities
{

	public static Connection getConnection()
	{


		Connection conn=null;
			try{

					Class.forName("com.mysql.jdbc.Driver").newInstance();
	  			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdeals?useSSL=true","root","root");

	 			}
	 catch (Exception e)
	 {}
return conn;
	}

	public static void DeleteRegi(String nm)
	{
		try{
	Connection conn=getConnection();
	conn.createStatement().executeUpdate("Delete from registration where username=\""+nm+"\"");
			}
catch(Exception e)
{

}
}

public static ResultSet login(String nm)
{
	ResultSet rs=null;
	try{
Connection conn=getConnection();
 rs = conn.createStatement().executeQuery("select * from registration where username=\""+nm+"\"");

		}
		catch (Exception e)
		{}
	return rs;
}
public static void signup(String name,String pass,String usertype)
{

	try{
Connection conn=getConnection();
 conn.createStatement().executeUpdate("Insert into registration values(\""+name+"\",\""+pass+"\",\""+pass+"\",\""+usertype+"\")");
		}
		catch (Exception e)
		{}

}

public static int Order(String name,String sum,String credit,String ad)
{
int id=0;
try
{
String prd="";

Connection conn=getConnection();
ResultSet rs = conn.createStatement().executeQuery("select max(OrderId) id from CustomerOrders");
while(rs.next()){
id=rs.getInt("id");
}
id=id+1;
rs = conn.createStatement().executeQuery("select name from cart");
while(rs.next()){
prd=rs.getString("name");
conn.createStatement().executeUpdate("Insert into ProductSales values("+id+",\""+prd+"\")");
}
conn.createStatement().executeUpdate("Delete from cart");
conn.createStatement().executeUpdate("Insert into CustomerOrders values("+id+",\""+name+"\","+sum+",\""+credit+"\",\""+ad+"\")");

}
catch(Exception e)
{

}
return id;

}


public static ResultSet TrendingZIP()
{
	ResultSet rs=null;
	try{
Connection conn=getConnection();
 rs = conn.createStatement().executeQuery("select main.zip,main.ct from (select main.zip,count(main.zip) ct from (select p.product prd,c.userAddress zip from ProductSales p left outer join customerorders c on  p.orderid=c.orderid) main group by main.zip) main order by main.ct desc");

		}
		catch (Exception e)
		{}
	return rs;
}
public static ResultSet Trendingprd()
{
	ResultSet rs=null;
	try{
Connection conn=getConnection();
 rs = conn.createStatement().executeQuery("select main.* from (select count(product) ct,product from productsales group by product)main order by main.ct desc");

		}
		catch (Exception e)
		{}
	return rs;
}

public static ResultSet Cart()
{
	ResultSet rs=null;
	try{
Connection conn=getConnection();
 rs = conn.createStatement().executeQuery("select * from Cart");

		}
		catch (Exception e)
		{}
	return rs;
}

public static ResultSet cartSum()
{
	ResultSet rs=null;
	try{
Connection conn=getConnection();
 rs = conn.createStatement().executeQuery("select sum(price) price from Cart" );

		}
		catch (Exception e)
		{}
	return rs;
}


public static void Deletecart(String nm)
{
	try{
Connection conn=getConnection();
conn.createStatement().executeUpdate("Delete from cart where name=\""+nm+"\"");
		}
catch(Exception e)
{

}
}


public static void CartUpdate(String name,String cond,String price)
{

	try{
Connection conn=getConnection();
 conn.createStatement().executeUpdate("Insert into cart values(\""+name+"\",\""+cond+"\",\""+price+"\")");
		}
		catch (Exception e)
		{}

}


public static ResultSet CustUpdate1()
{
	ResultSet rs=null;
	try{
Connection conn=getConnection();
 rs = conn.createStatement().executeQuery("select username from registration" );

		}
		catch (Exception e)
		{}
	return rs;
}

}
