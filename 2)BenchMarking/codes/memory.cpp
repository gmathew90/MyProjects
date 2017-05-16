/*
Done by George Mathew
as part of cloud computing assignment 1:Benchmarking
Memory Benchmarking
Program to measure the memory speed of the system
Read+write operations using random and sequential memory access with varying block sizes 1B,1KB and 1MB is done
 */
#include<stdio.h>
#include<iostream>
#include<ctime>
#include<stdlib.h>
#include<string.h>
#include<thread>
#include<memory.h>
char b1[1],a[1];
char mb1[1048576],ma[1048576];
char kb1[1024],ka[1024];
int b=1;
int kb=1024;
int mb=1048576;
int const dt=10485760;
char data[dt];
char data2[dt];
int kbdt=10*1024;
int mbdt=10;
void bcopy1()//function to sequentially write 10 mb of data using block size 1B
{
  for(int i=0;i<dt;i++)
    {
      memcpy(&data2[i],&data[i],1);
      }
    }

 void mcopy1()//function to sequentially write 10 mb of data using block size 1MB
{
  for(int i=0;i<mbdt;i++){
    
  memcpy(&data2[i*mb],&data[i*mb],mb);
  }
}
//function to sequentially write 10 mb of data using block size 1KB
void kcopy1(){
  for(int i=0;i<kbdt;i++)
    {
  memcpy(&data2[i*kb],&data[i*kb],kb);
    }
}

void bcopy1r()//function to Randomly write 10 mb of data using block size 1B
  
{
 for(int i=0;i<dt;i++)
    {
      int r=rand()%dt;//This helps to find a random location in the memory
     
      memcpy(&data2[i],&data[r],1);
      }
    }

 void mcopy1r()//function to Randomly write 10 mb of data using block size 1MB
{
 
 for(int i=0;i<mbdt;i++)
    {
      int r=rand()%mbdt;//This helps to find a random location in the memory
      memcpy(&data2[i*mb],&data[r],mb);
      }
    }

void kcopy1r()//function to Randomly write 10 mb of data using block size 1KB
{
 
 for(int i=0;i<kbdt;i++)
    {
      int r=rand()%kbdt;//This helps to find a random location in the memory
      memcpy(&data2[i*kb],&data[r],kb);
      }
    }





int main()
{
 
 
  typedef std::chrono::high_resolution_clock Time;
  typedef std::chrono::milliseconds ms;
  typedef std::chrono::duration<float> fsec;
  int inp;
  int t;
  auto t0=Time::now();
  auto t1=Time::now();
  fsec fs;
  ms d;
  for(int i=0;i<dt;i++)//Assign value to the 10 MB buffer which will be used to write
    {
    data[i]='t';
  }
  //Display the Menu
  std::cout<<"Menu \n"<<"1)Sequential Data Transfer 1 Byte \n"<<"2)Sequential Data Transfer 1 KB \n"<<"3)Sequential Data Transfer 1MB \n"<<"4)Random Data Transfer 1 Byte\n"<<"5)Random Data Transfer 1 KB\n"<<"6)Random Data Transfer 1 MB\n";
    std::cin>>inp;
    std::cout<<"Input the number of threads (1 or 2)\n";
    std::cin>>t;//Take in the number of threads
    if(t==1){
      std::cout<<"1 thread is being used \n";}
    else{
      std::cout<<"2 threads are being used\n";}



    
    if(inp==1)//Code to Sequentially Transfer 1 Byte of data using the input number of threads
    {
    std::cout<<"Sequential Data Transfer 1 Byte\n";
    t0 = Time::now();//time before excecution is noted
    int n=100;// the function for data transfer is called n times to get more accurate values
    for(int i=0;i<n;i++){
    if(t==1){
      std::thread t1 (bcopy1);//if the value of threads is one only one instance of the function is called
	t1.join();
	 }
    if(t==2){
      std::thread t1 (bcopy1);//if the value of threads is two ,two instances of the function is called
      std::thread t2 (bcopy1);
      t1.join();
      t2.join();


    }
      }
    t1 = Time::now();//end time is noted
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);
    
    std::cout<<"Latency:";
    std::cout<<(d.count()/(float)1000)/(t*n*dt)<<"s\n"; //Latency and Throughput is calculated using the amount of data transfered and time taken for excecution
    std::cout<<"Throughput:";
    std::cout<<(t*n*10)/(d.count()/(float)1000)<<"MB/s\n";
    }



  if(inp==2)//Code to Sequentially Transfer 1 KB of data using the input number of threads
    {
    std::cout<<"Sequential Data Transfer 1 KB\n";
    t0 = Time::now();//time before excecution is noted
    int n=1000;// the function for data transfer is called n times to get more accurate values
    for(int i=0;i<n;i++){
    if(t==1){
      std::thread t1 (kcopy1);//if the value of threads is one only one instance of the function is called
	t1.join();
	 }
    if(t==2){
      std::thread t1 (kcopy1);//if the value of threads is two,two instances of the function areis called
      std::thread t2 (kcopy1);
      t1.join();
      t2.join();


    }
      }
    t1 = Time::now();//end time is noted
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);
    
     std::cout<<"Latency:";
    std::cout<<(d.count()/(float)1000)/(t*n*kbdt)<<"s\n"; //Latency and Throughput is calculated using the amount of data transfered and time taken for excecution
    std::cout<<"Throughput:";
  
    std::cout<<(t*n*10)/(d.count()/(float)1000)<<"MB/s\n";
    }





  if(inp==3)//Code to Sequentially Transfer 1 MB of data using the input number of threads
    {
    std::cout<<"Sequential Data Transfer 1 MB\n";
    t0 = Time::now();//time before excecution is noted
    int n=1000;// the function for data transfer is called n times to get more accurate values
    for(int i=0;i<n;i++){
    if(t==1){
      std::thread t1 (mcopy1);
	t1.join();
	 }
    if(t==2){
      std::thread t1 (mcopy1);//if the value of threads is two,two instances of the function areis called
      std::thread t2 (mcopy1);
      t1.join();
      t2.join();


    }
      }
    t1 = Time::now();//end time is noted
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);
    
    std::cout<<"Latency:";
    std::cout<<(d.count()/(float)1000)/(t*n*mbdt)<<"s\n"; //Latency and Throughput is calculated using the amount of data transfered and time taken for excecution
    std::cout<<"Throughput:";
  
    std::cout<<(t*n*10)/(d.count()/(float)1000)<<"MB/s\n";
    }

  
  if(inp==4)//Code to Randomly Transfer 1 Byte of data using the input number of threads
    {
    std::cout<<"Random Data Transfer 1 Byte\n";
    t0 = Time::now();//time before excecution is noted
    int n=10;// the function for data transfer is called n times to get more accurate values
    for(int i=0;i<n;i++){
    if(t==1){
      std::thread t1 (bcopy1r);
	t1.join();
	 }
    if(t==2){
      std::thread t1 (bcopy1r);//if the value of threads is two,two instances of the function areis called
      std::thread t2 (bcopy1r);
      t1.join();
      t2.join();


    }
      }
    t1 = Time::now();//end time is noted
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);//end time is noted
    
    std::cout<<"Latency:";
    std::cout<<(d.count()/(float)1000)/(t*n*dt)<<"s\n"; //Latency and Throughput is calculated using the amount of data transfered and time taken for excecution
    std::cout<<"Throughput:";
    
    std::cout<<(t*n*10)/(d.count()/(float)1000)<<"MB/s\n";
    }


  if(inp==5)//Code to Randomly Transfer 1 KB of data using the input number of threads
    {
    std::cout<<"Random Data Transfer 1 Kb\n";
   t0 = Time::now();//time before excecution is noted
    int n=1000;// the function for data transfer is called n times to get more accurate values
    for(int i=0;i<n;i++){
    if(t==1){
      std::thread t1 (kcopy1);
	t1.join();
	 }
    if(t==2){
      std::thread t1 (kcopy1);//if the value of threads is two,two instances of the function areis called
      std::thread t2 (kcopy1);
      t1.join();
      t2.join();


    }
      }
    t1 = Time::now();//end time is noted
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);
    
     std::cout<<"Latency:";
    std::cout<<(d.count()/(float)1000)/(t*n*kbdt)<<"s\n"; //Latency and Throughput is calculated using the amount of data transfered and time taken for excecution
    std::cout<<"Throughput:";
  
    std::cout<<(t*n*10)/(d.count()/(float)1000)<<"MB/s\n";
    }


  if(inp==6)//Code to Randomly Transfer 1 Mb of data using the input number of threads
    {
    std::cout<<"Random Data Transfer 1 Mb\n";
    t0 = Time::now();//time before excecution is noted
    int n=1000;// the function for data transfer is called n times to get more accurate values
    for(int i=0;i<n;i++){
    if(t==1){
      std::thread t1 (mcopy1);
	t1.join();
	 }
    if(t==2){
      std::thread t1 (mcopy1);//if the value of threads is two,two instances of the function areis called
      std::thread t2 (mcopy1);
      t1.join();
      t2.join();


    }
      }
    t1 = Time::now();
    fs = t1 - t0;
    d = std::chrono::duration_cast<ms>(fs);
    
    std::cout<<"Latency:";
    std::cout<<(d.count()/(float)1000)/(t*n*mbdt)<<"s\n";//Latency and Throughput is calculated using the amount of data transfered and time taken for excecution
    std::cout<<"Throughput:";
  
    std::cout<<(t*n*10)/(d.count()/(float)1000)<<"MB/s\n";
    }
	      
  return 0;
}
