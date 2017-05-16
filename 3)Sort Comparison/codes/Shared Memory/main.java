import java.io.*;
import java.util.*;
import java.util.Arrays;


class main implements Runnable
{
    static final int l=107000000;
    static final int n=50;
    static final int t=2;
    static String temp[]=new String[l/n];
    static String temps[]=new String[l/n/4];
    static String[] tempMerg;
    static int y,z;
    public void run()
    {
     try{
      readf();
      }
     catch(IOException e){
     }
    }
    static void readf()throws IOException //function used to read from the first file
    {
    int c=0;
    int nmc=0;
    BufferedReader br = new BufferedReader(new FileReader("input"));
    String s=br.readLine();
    
        while(s!=null) //divide into chunks
        {
        temp[c]=(s);
	c=c+1;
	s=br.readLine();
	if(c==l/n)
	{
         sort();
         writef("/mnt2/"+nmc+"file"); //write into individual file
         nmc=nmc+1;
	 c=0;
         //System.out.println((nmc*100/n)+"% Percent complete");
	}
        }
    br.close();
    }
    

    static void writef(String nm)throws IOException
    {
    FileWriter fw = new FileWriter(nm); //function used to write into the files
    for (int i = 0; i < temp.length; i++)
        {
        fw.write(temp[i] + " \n");
        }
        fw.close();
    }
    


    






    public static void sort() {
        tempMerg= new String[temp.length];
        mrgsrt(0, temp.length - 1); // calling the mrgsrt function
    }
 
    


    public static void mrgsrt(int l, int h) {
         
        if (l < h) {
            
            int m= l+(h -l)/2; //finding the middle 
            mrgsrt(l,m);// mrsrt ing the left part
            
            
       
	    
            mrgsrt(m+1,h);//mrgsrt ing the right part.These two steps are done recursively till the file becomes individual chunks of data
            
     
            mrg(l,m,h);//the chunks are combined after the division
    	    
        }
    }
 
    


    public static void mrg(int l, int m, int h) {
 		//this function merges the individual chunks by sorting them
        for (int i = l; i <= h; i++) {
            tempMerg[i] = temp[i];
        }
        int i = l;
        int j = m + 1;
        int k = l;
        while (i <= m && j <= h) {
            if (tempMerg[i].compareTo(tempMerg[j])<=0) {
                temp[k] = tempMerg[i];
                i++;
            } else {
                temp[k] = tempMerg[j];
                j++;
            }
            k++;
        }
        while (i <= m) {
            temp[k] = tempMerg[i];
            k++;
            i++;
        }
 
    }

    

   public static void main(String args[]) throws IOException,InterruptedException
    {
   	Date d=new Date();
    	long t1=d.getTime();//store the start time 
      	System.out.println("Sorting and dividing  into Chunks");
    	
	readf();//the function to divide into chunks is called
    	
    	//System.out.println("Doing External Sort");
    	//extsort();
	Date d2=new Date();
	long t2=d2.getTime(); //store the end time
	System.out.println(("Time Taken "+(t2-t1)/1000)+"s"); //time taken is computed and displayed
    }
}
