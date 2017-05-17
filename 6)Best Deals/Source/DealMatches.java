
import java.io.*;
import java.util.*;


public class DealMatches
{
	ArrayList<String> Deals = new ArrayList<String>();
	ArrayList<String> Id = new ArrayList<String>();
	public  DealMatches()
	{
		try{
		FileReader fl=new FileReader("C:/apache-tomcat-7.0.34/bin/DealMatches.txt");
		BufferedReader br = new BufferedReader(fl);
		String line;
		int cnt=0;
    while ((line = br.readLine()) != null && cnt<2) {
    String[] parts = line.split("<!split!>");
    cnt=cnt+1;
		Id.add(parts[0]);
		Deals.add(parts[1]);

	 }
 }
 catch(Exception e){}

	}
}
