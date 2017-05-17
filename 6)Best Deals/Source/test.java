import java.io.IOException;
import java.sql.*;

 class test
{
public static void main (String[] args) throws IOException
{
Connection conn = null;
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
System.out.println("Driver Registerd");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdeals?useSSL=true","root","root");
System.out.println("Connecton established");
ResultSet rs = conn.createStatement().executeQuery("select password from registration");
System.out.println("Query Excecuted");
while(rs.next()){
System.out.println(rs.getString("password"));
}
}
catch (Exception e)
{
System.out.println("Error");
}

}
}