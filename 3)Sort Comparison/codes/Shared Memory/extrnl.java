import java.io.*;
import java.util.*;
import java.util.Arrays;


class extrnl implements Runnable
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
	if(c==l/n)
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
    


    static void extsort() throws IOException //external sort function
    {
    int tmk=0;
    int fp[]=new int[n]; //array to store the point in file to which data has been read
    int flg[]=new int[n]; //array used to store the point in the buffer to which data has been written
    int a=l/n/n;
    String buff[][]=new String[n][a]; //buffer that holds value for sorting
    String ax=null;
    int i_b=0;
    int f_b=0;
    int num=0;
    System.out.println(a);
    for(int i=0;i<n;i++)
        {
        fp[i]=0;
        flg[i]=a;
        }
    System.out.println("Flags initiated and Reading from Chunks");
    FileWriter fw = new FileWriter("/d/Output");
    while(num<l){
    for (int i=0;i<n;i++)
        {
        if(flg[i]==a) //checkin whether the data in the buffer from this file is over or not
            {
            //System.out.println(i+"file");
            RandomAccessFile file = new RandomAccessFile("/c/"+i+"file", "r");
            file.seek(100*fp[i]); //seek the file pointer till the pointer of the file
            fp[i]=fp[i]+a;
            for(int j=0;j<a;j++)
                {
                //System.out.println(j);
                buff[i][j]=file.readLine();
                if(buff[i][j]==null)
                    {
                    buff[i][j]=Character.toString((char)255); //storing the value into the buffer
                    }
                ax=buff[i][j];
                }
            flg[i]=0;
            file.close();
           
            }
        }
    //System.out.println((l-num));
    ax=Character.toString((char)255);
    for(int i=0;i<n;i++) //loop that finds the smallest element in the buffer
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
    
   fw.write(ax+ "\n"); //write that file
	
    num=num+1;
    }
    fw.close();
    }




   
    

   public static void main(String args[]) throws IOException,InterruptedException
    {
   	Date d=new Date();
    	long t1=d.getTime();//initial time is noted
      	//System.out.println("Sorting and dividing  into Chunks");
    	
	//readf();
    	
    	System.out.println("Doing External Sort");
    	extsort();//external sort is done
	Date d2=new Date();
	long t2=d2.getTime();//end time is noted 
	System.out.println(("Time Taken "+(t2-t1)/1000)+"s");//total time taken is computed
    }
}
