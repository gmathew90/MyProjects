import java.io.*;
 class wr
{
public static void main (String[] args) throws IOException
{
String id="S2";
String name="Nexus 5x";
String condition="New";
String price="400";
int count=0;
int flg=0;
BufferedReader reader = new BufferedReader(new FileReader ("SmartPhones_Items.xml"));
BufferedReader reader_count = new BufferedReader(new FileReader ("SmartPhones_Items.xml"));
String         line = null;
StringBuilder  stringBuilder = new StringBuilder();
String         ls = System.getProperty("line.separator");

while((line = reader_count.readLine()) != null) {
count++;
}
flg=count-3;
count=0;
while(count<=flg) {
line = reader.readLine();
stringBuilder.append(line);
stringBuilder.append(ls);
count++;
}
stringBuilder.append("   <item id=\""+id+"\" retailer=\"Samsung\">");
stringBuilder.append(ls);
stringBuilder.append("       <image>"+id+".jpg</image>");
stringBuilder.append(ls);
stringBuilder.append("        <name>"+name+"</name>");
stringBuilder.append(ls);
stringBuilder.append("        <condition>"+condition+"</condition>");
stringBuilder.append(ls);
stringBuilder.append("        <price>"+price+"</price>");
stringBuilder.append(ls);
stringBuilder.append("    </item>");
stringBuilder.append(ls);
stringBuilder.append("</ProductCatalog>");
stringBuilder.append(ls);
reader.close();        
reader_count.close();

PrintWriter out = new PrintWriter("SmartPhones_Items.xml");
out.println(stringBuilder.toString());
out.close();


    

}

}