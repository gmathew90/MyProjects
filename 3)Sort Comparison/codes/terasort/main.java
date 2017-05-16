import java.io.*;
import java.util.*;
import java.util.Arrays;


class main implements Runnable
{
    static final long l=10995000000L;
    static final int n=250;
    static final int t=2;
    static String temp[]=new String[43980000];
    //static String temps[]=new String[54975575];
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
    static void readf()throws IOException
    {
    int c=0;
    int nmc=0;
    BufferedReader br = new BufferedReader(new FileReader("input"));
    String s=br.readLine();
    
        while(s!=null)
        {
        temp[c]=(s);
	c=c+1;
	s=br.readLine();
	if(c==43980000)
	{
         sort();
         writef("/c/"+nmc+"file");
         nmc=nmc+1;
	 c=0;
         System.out.println((nmc*100/n)+"% Percent complete");
	}
        }
    br.close();
    }
    

    static void writef(String nm)throws IOException
    {
    FileWriter fw = new FileWriter(nm);
    for (int i = 0; i < temp.length; i++)
        {
        fw.write(temp[i] + " \n");
        }
        fw.close();
    }
    


    static void extsort() throws IOException
    {
    int tmk=0;
    int fp[]=new int[n];
    int flg[]=new int[n];
    int a=175920;
    String buff[][]=new String[n][a];
    BufferedReader br[]=new BufferedReader[n];
    String ax=null;
    int i_b=0;
    int f_b=0;
    long num=0L;
    System.out.println(a);
    for(int i=0;i<n;i++)
        {
        fp[i]=0;
        flg[i]=a;
	br[i]=new BufferedReader(new FileReader("/c/"+i+"file"));
        }
    System.out.println("Flags initiated and Reading from Chunks");
    FileWriter fw = new FileWriter("/d/Output");
    while(num<l){
    for (int i=0;i<n;i++)
        {
        if(flg[i]==a)
            {
            //System.out.println(i+"file");
		// RandomAccessFile file = new RandomAccessFile(i+"file", "r");
		// file.seek(100*fp[i]);
            fp[i]=fp[i]+a;
            for(int j=0;j<a;j++)
                {
                //System.out.println(j);
                buff[i][j]=br[i].readLine();
                if(buff[i][j]==null)
                    {
                    buff[i][j]=Character.toString((char)255);
                    }
                ax=buff[i][j];
                }
            flg[i]=0;
	    // file.close();
           
            }
        }
    //System.out.println((l-num));
    ax=Character.toString((char)255);
    for(int i=0;i<n;i++)
        {
        //System.out.println("Test");
        //System.out.println(buff[i][flg[i]]);
        if(ax.compareTo(buff[i][flg[i]])>=0)
        {
            ax=buff[i][flg[i]];
            i_b=i;
           
        }

        }
   
    flg[i_b]=flg[i_b]+1;
    //System.out.println(ax);
    //System.out.println(i_b);
    
   fw.write(ax+ "\n");
    
    num=num+1;
    }
    fw.close();
    }






    public static void sort() {
        tempMerg= new String[temp.length];
        MergeSort(0, temp.length - 1);
    }
 
    


    public static void MergeSort(int l, int h) {
         
        if (l < h) {
            
            int m= l+(h -l)/2;
            MergeSort(l,m);
            
            
       
	    
            MergeSort(m+1,h);
            
     
            merge(l,m,h);
    	    
        }
    }
 
    


    public static void merge(int l, int m, int h) {
 
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
    	long t1=d.getTime();
      	System.out.println("Sorting and dividing  into Chunks");
    	
	readf();
    	
    	System.out.println("Doing External Sort");
    	extsort();
	Date d2=new Date();
	long t2=d2.getTime();
	System.out.println(("Time Taken "+(t2-t1)/1000)+"s");
    }
}
