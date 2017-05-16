/*
Done by George Mathew
as part of cloud computing assignment 1:Benchmarking
Disk Benchmarking
Program to measure the disk  speed of the system
Read and write operations using random and sequential memory access with varying block sizes 1B,1KB and 1MB are done
 */


#include<iostream>
#include<time.h>
#include<stdlib.h>
#include<thread>
#include<pthread.h>
int bm=1024*1024*10;
char *buffer_g=new char[bm];
char *buffer_g2=new char[bm];
int bk=1024*5;
char *buffer_m= new char[bk];
int bu=1024;
char *buffer= new char[bu];
char *buffer_k=new char[1024];
char *buffer_b=new char[1];
 
FILE *fp;
FILE *fp2;

void*  byte_transfer_write()
//Function to write 1 kb of data sequentially with 1 Byte block size
{  
 
 
  fp=fopen("byte.txt","w");

  for(int i=0;i<bu;i++){
    fwrite(&buffer[i],1,1,fp);}
  fclose(fp);
  
 
  
}
void* byte_transfer_read()//Function to read 1 kb of data sequentially with 1 Byte block size
{
 
  fp=fopen("byte.txt","r");
  for(int i=0;i<bu;i++){
    fread(&buffer[i],1,1,fp);}
  fclose(fp);
  
}

void* kb_transfer_write()//Function to write 5 kb of data sequentially with 1 kb block size
{
   
  fp=fopen("kb.txt","w");
  for(int i=0;i<5;i++){
    fseek(fp,i*1024,SEEK_SET);
    fwrite(&buffer_m[i*1024],1024,1,fp);}
  fclose(fp);
 }

void* kb_transfer_read()//Function to write 5 kb of data sequentially with 1 kb block size
{
 
  fp=fopen("kb.txt","r");
  
  for(int i=0;i<5;i++){
    fseek(fp,i*1024,SEEK_SET);
    fread(&buffer_m[i*1024],1024,1,fp);}
    fclose(fp);
 }

void* mb_transfer_write()//Function to write 10MB of data sequentially with 1 Mb block size
{
 
  fp=fopen("mb.txt","w");
  
   for(int i=0;i<10;i++){
    fseek(fp,i*1024*1024,SEEK_SET);
    fwrite(&buffer_g[i*1024*1024],1024*1024,1,fp);
    }
    fclose(fp);
  
}






void* mb_transfer_read()//Function to read 10MB of data sequentially with 1 Mb block size
{
  
  fp=fopen("mb.txt","r");
  
    for(int i=0;i<10;i++){
    fseek(fp,i*1024*1024,SEEK_SET);
    fread(&buffer_g[i*1024*1024],1024*1024,1,fp);}
    fclose(fp);
  
}
void* kb_transfer_write_r()//Function to write 1 kb of data randomly with 1 Byte block size
{
   
  fp=fopen("kb1.txt","w");
  for(int i=0;i<5;i++){
    int r=rand()%5;
    fseek(fp,r*1024,SEEK_SET);
    fwrite(&buffer_m[i*1024],1024,1,fp);}
  fclose(fp);
 }

void* kb_transfer_read_r()//Function to read 1 kb of data randomly with 1 Byte block size
{
 
  fp=fopen("kb.txt","r");
  
  for(int i=0;i<5;i++){
    int r=rand()%1024;
    fseek(fp,r*1024,SEEK_SET);
    
    fread(&buffer_m[i*1024],1024,1,fp);}
    fclose(fp);
 }







void*  byte_transfer_write_r()//Function to write 5 kb of data randomly with 1 KB block size
{
  
 
 
  fp=fopen("byte1.txt","w");

  for(int i=0;i<bu;i++){
    int r=rand()%bu;
    fseek(fp,r,SEEK_SET);
    fwrite(&buffer[i],1,1,fp);}
  fclose(fp);
  
 
  
}
void* byte_transfer_read_r()//Function to read 5 kb of data randomly with 1 KB block size
{
 
  fp=fopen("byte.txt","r");
  for(int i=0;i<bu;i++){
    int r=rand()%bu;
    fseek(fp,r,SEEK_SET);
    fread(&buffer[i],1,1,fp);}
  fclose(fp);
  
}


void* mb_transfer_write_r()//Function to write 10 Mb of data randomly with 1 MB block size
{
 
  fp=fopen("mb1.txt","w");
  
    for(int i=0;i<10;i++){
      int r=rand()%10;
    fseek(fp,r*1024*1024,SEEK_SET);
    fwrite(&buffer_g[i*1024*1024],1024*1024,1,fp);}
    fclose(fp);
  
}






void* mb_transfer_read_r()//Function to read 10 Mb of data randomly with 1 MB block size
{
  
  fp=fopen("mb.txt","r");
  
    for(int i=0;i<10;i++){
     int r=rand()%10;
    fseek(fp,r*1024*1024,SEEK_SET);
    fread(&buffer_g[i*1024*1024],1024*1024,1,fp);}
    fclose(fp);
  
}

int main(){
  typedef std::chrono::high_resolution_clock Time;
  typedef std::chrono::milliseconds ms;
  typedef std::chrono::duration<float> fsec;
  int inp;
  int t;
  auto t0=Time::now();
  auto t1=Time::now();
  fsec fs;
  ms d;//The buffers are initialized
  for(int i=0;i<(bu);i++){
    buffer[i]='t';
  }
   for(int i=0;i<(bk);i++){
    buffer_m[i]='t';
  }
    for(int i=0;i<(bm);i++){
    buffer_g[i]='t';
  }
    
    //Menu is displayed
  std::cout<<"Menu \n"<<"1)Sequential Data Transfer 1 Byte \n"<<"2)Sequential Data Transfer 1 KB \n"<<"3)Sequential Data Transfer 1MB \n"<<"4)Random Data Transfer 1 Byte\n"<<"5)Random Data Transfer 1 KB\n"<<"6)Random Data Transfer 1 MB\n";
  std::cin>>inp;//The number of threads are input
    std::cout<<"Input the number of threads (1 or 2)\n";
    std::cin>>t;
    if(t==1){
      std::cout<<"Using one thread\n";}
    if(t==2){
      std::cout<<"Using two threads\n";}
  if(inp==1){
    std::cout<<"Sequential Data Transfer 1 Byte \n";
    t0 = Time::now();//Initial Time is noted and the experiment is done n times
    int n=10000;
    for(int i=0;i<n;i++){
      if(t==1){
	
	std::thread th1(byte_transfer_write);
	th1.join();}
      if(t==2){
	
	std::thread th1(byte_transfer_write);
	th1.join();
	std::thread th2(byte_transfer_write);

	th2.join();}
        }
    t1 = Time::now(); //end time is noted
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);
    std::cout<<"Write\n";
    std::cout<<"Latency:";
    float la=(d.count()/(float)1000)/(n*bu*t);//The Throughput and Latency is calculated using the amount of data transfered and time taken 
    std::cout<<la<<'\n';
    std::cout<<"Throughput:";
    
    std::cout<<(t*n*bu/1024/1024)/(d.count()/(float)1000)<<"MB/s\n";
    n=10000;
     t0 = Time::now();//Initial Time is noted and the experiment is done n times
     for(int i=0;i<n;i++){
      if(t==1){
	
	std::thread th1(byte_transfer_read);
	th1.join();}
      if(t==2){
	
	std::thread th1(byte_transfer_read);
	std::thread th2(byte_transfer_read);
	th1.join();
	th2.join();}
      }
    t1 = Time::now();//end time is noted
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);
    std::cout<<"Read\n";
   
    std::cout<<"Latency:";
    
    std::cout<<(d.count()/(float)1000)/(n*bu*t)<<'\n';//The Throughput and Latency is calculated using the amount of data transfered and time taken
    std::cout<<"Throughput:";
    
    std::cout<<(t*n*bu/1024/1024)/(d.count()/(float)1000)<<"MB/s\n";
    
    


  }



  
  if(inp==2)
    {
      std::cout<<"Sequential Data Transfer 1 KB \n";
      t0 = Time::now();//Initial Time is noted and the experiment is done n times
    int n=10000;
    for(int i=0;i<n;i++){
      if(t==1){
	
	std::thread th1(kb_transfer_write);
	th1.join();}
      if(t==2){
	
	std::thread th1(kb_transfer_write);
	std::thread th2(kb_transfer_write);
	th1.join();
	th2.join();}
        }
    t1 = Time::now();//end time is noted
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);
    std::cout<<"Write\n";
    std::cout<<"Latency:";
    float la=(d.count()/(float)1000)/(n*5*t);
    std::cout<<la<<'\n';
    std::cout<<"Throughput:";
    
    std::cout<<(t*n*bk/1024/1024)/(d.count()/(float)1000)<<"MB/s\n";//The Throughput and Latency is calculated using the amount of data transfered and time taken
    n=100000;
     t0 = Time::now();//Initial Time is noted and the experiment is done n times
     for(int i=0;i<n;i++){
      if(t==1){
	
	std::thread th1(kb_transfer_read);
	th1.join();}
      if(t==2){
	
	std::thread th1(kb_transfer_read);
	th1.join();
	std::thread th2(kb_transfer_read);
	th2.join();}
      }
    t1 = Time::now();//end time is noted
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);
    std::cout<<"Read\n";
   
    std::cout<<"Latency:";
    
    std::cout<<(d.count()/(float)1000)/(n*5*t)<<'\n';//The Throughput and Latency is calculated using the amount of data transfered and time taken
    std::cout<<"Throughput:";
    
    std::cout<<(t*n*bk/1024/1024)/(d.count()/(float)1000)<<"MB/s\n";
    
  }



  
  if(inp==3){
    std::cout<<"Sequential Data Transfer 1MB \n";
      t0 = Time::now();//Initial Time is noted and the experiment is done n times
    int n=100;
    for(int i=0;i<n;i++){
      if(t==1){
	
	std::thread th1(mb_transfer_write);
	th1.join();}
      if(t==2){
	
	std::thread th1(mb_transfer_write);
	th1.join();
	std::thread th2(mb_transfer_write);
	
	th2.join();}
        }
    t1 = Time::now();
    fs = t1 - t0;//end time is noted
    d = std::chrono::duration_cast<ms>(fs);
    std::cout<<"Write\n";
    std::cout<<"Latency:";
    float la=(d.count()/(float)1000)/(n*10*t);
    std::cout<<la<<'\n';
    std::cout<<"Throughput:";
    
    std::cout<<(t*n*bm/1024/1024)/(d.count()/(float)1000)<<"MB/s\n";//The Throughput and Latency is calculated using the amount of data transfered and time taken
    n=500;
     t0 = Time::now();//Initial Time is noted and the experiment is done n times
     for(int i=0;i<n;i++){
      if(t==1){
	
	std::thread th1(mb_transfer_read);
	th1.join();}
      if(t==2){
	
	std::thread th1(mb_transfer_read);
	th1.join();
	std::thread th2(mb_transfer_read);
	
	th2.join();}
      }
    t1 = Time::now();//end time is noted
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);
    std::cout<<"Read\n";
   
    std::cout<<"Latency:";
    
    std::cout<<(d.count()/(float)1000)/(n*10*t)<<'\n';//The Throughput and Latency is calculated using the amount of data transfered and time taken
    std::cout<<"Throughput:";
    
    std::cout<<(t*n*bm/1024/1024)/(d.count()/(float)1000)<<"MB/s\n";

}




    
  if(inp==5){
    std::cout<<"Random Data Transfer 1 KB\n";
   t0 = Time::now();//Initial Time is noted and the experiment is done n times
    int n=10000;
    for(int i=0;i<n;i++){
      if(t==1){
	
	std::thread th1(kb_transfer_write_r);
	th1.join();}
      if(t==2){
	
	std::thread th1(kb_transfer_write_r);
	std::thread th2(kb_transfer_write_r);
	th1.join();
	th2.join();}
        }
    t1 = Time::now();//end time is noted
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);
    std::cout<<"Write\n";
    std::cout<<"Latency:";
    float la=(d.count()/(float)1000)/(n*5*t);
    std::cout<<la<<'\n';
    std::cout<<"Throughput:";
    
    std::cout<<(t*n*bk/1024/1024)/(d.count()/(float)1000)<<"MB/s\n";//The Throughput and Latency is calculated using the amount of data transfered and time taken
    n=100000;
     t0 = Time::now();//Initial Time is noted and the experiment is done n times
     for(int i=0;i<n;i++){
      if(t==1){
	
	std::thread th1(kb_transfer_read_r);
	th1.join();}
      if(t==2){
	
	std::thread th1(kb_transfer_read_r);
	std::thread th2(kb_transfer_read_r);
	th1.join();
	th2.join();}
      }
    t1 = Time::now();//end time is noted
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);
    std::cout<<"Read\n";
   
    std::cout<<"Latency:";
    
    std::cout<<(d.count()/(float)1000)/(n*5*t)<<'\n';
    std::cout<<"Throughput:";
    
    std::cout<<(t*n*bk/1024/1024)/(d.count()/(float)1000)<<"MB/s\n";//The Throughput and Latency is calculated using the amount of data transfered and time taken

}



  
   if(inp==6){
     std::cout<<"Random Data Transfer 1 MB\n";
     t0 = Time::now();//Initial Time is noted and the experiment is done n times
    int n=100;
    for(int i=0;i<n;i++){
      if(t==1){
	
	std::thread th1(mb_transfer_write_r);
	th1.join();}
      if(t==2){
	
	std::thread th1(mb_transfer_write_r);
	th1.join();
	std::thread th2(mb_transfer_write_r);
	
	th2.join();}
        }
    t1 = Time::now();//end time is noted
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);
    std::cout<<"Write\n";
    std::cout<<"Latency:";
    float la=(d.count()/(float)1000)/(n*10*t);
    std::cout<<la<<'\n';
    std::cout<<"Throughput:";
    
    std::cout<<(t*n*bm/1024/1024)/(d.count()/(float)1000)<<"MB/s\n";//The Throughput and Latency is calculated using the amount of data transfered and time taken
    n=500;
     t0 = Time::now();//Initial Time is noted and the experiment is done n times
     for(int i=0;i<n;i++){
      if(t==1){
	
	std::thread th1(mb_transfer_read_r);
	th1.join();}
      if(t==2){
	
	std::thread th1(mb_transfer_read_r);
	th1.join();
	std::thread th2(mb_transfer_read_r);
	
	th2.join();}
      }
    t1 = Time::now();//end time is noted
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);
    std::cout<<"Read\n";
   
    std::cout<<"Latency:";
    
    std::cout<<(d.count()/(float)1000)/(n*10*t)<<'\n';//The Throughput and Latency is calculated using the amount of data transfered and time taken
    std::cout<<"Throughput:";
    
    std::cout<<(t*n*bm/1024/1024)/(d.count()/(float)1000)<<"MB/s\n";

}

    if(inp==4){
      std::cout<<"Random Data Transfer 1 Byte\n";
     t0 = Time::now();//Initial Time is noted and the experiment is done n times
    int n=10000;
   
    for(int i=0;i<n;i++){
      if(t==1){
	
	  std::thread th1(byte_transfer_write_r);
	  th1.join();}
	 
	  
      if(t==2){
	
       std::thread th1(byte_transfer_write_r);
       th1.join();
       std::thread th2(byte_transfer_write_r);
	th2.join();
	}
        }
    t1 = Time::now();//end time is noted
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);
    std::cout<<"Write\n";
    std::cout<<"Latency:";
    float la=(d.count()/(float)1000)/(n*bu*t);
    std::cout<<la<<'\n';
    std::cout<<"Throughput:";
    
    std::cout<<(t*n*bu/1024/1024)/(d.count()/(float)1000)<<"MB/s\n";//The Throughput and Latency is calculated using the amount of data transfered and time taken
    n=10000;
     t0 = Time::now();//Initial Time is noted and the experiment is done n times
     for(int i=0;i<n;i++){
      if(t==1){
	
	std::thread th1(byte_transfer_read_r);
	th1.join();}
      if(t==2){
	
	std::thread th1(byte_transfer_read_r);
	th1.join();
	std::thread th2(byte_transfer_read_r);
	th2.join();}
      }
    t1 = Time::now();//end time is noted
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);
    std::cout<<"Read\n";
   
    std::cout<<"Latency:";
    
    std::cout<<(d.count()/(float)1000)/(n*bu*t)<<'\n';//The Throughput and Latency is calculated using the amount of data transfered and time taken
    std::cout<<"Throughput:";
    
    std::cout<<(t*n*bu/1024/1024)/(d.count()/(float)1000)<<"MB/s\n";
    
    


}

  
  return 0;
}
