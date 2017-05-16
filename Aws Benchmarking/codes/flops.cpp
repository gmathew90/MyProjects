/*
Done by George Mathew
as part of cloud computing assignment 1:Benchmarking
CPU Benchmarking:GFLOP calculation
Program to measure the CPU Processing speed in GFLOPS

 */

#include<iostream>
#include<time.h>
#include<stdlib.h>
#include<thread>
#include<fstream>
const int n=1000;
 float k=0;
void mul(int a[n][n],int b[n][n],int p)//Fuction to do GFLOPS
{
  for(float l=0;l<(float)p;l=l+float(1))
    {
      for(float i=0;i<(float)n;i=i+(float)1)
	{
	  for(float j=0;j<(float)n;j=j+(float)1)
	    {
	      k=a[(int)i][(int)j]/b[(int)i][(int)j];
	  
	    }
	}
    }
  
}
int main()
{
  
 
  int p=1000;
  typedef std::chrono::high_resolution_clock Time;
  typedef std::chrono::milliseconds ms;
  typedef std::chrono::duration<float> fsec;
  double tim;
  float  iops;
  int t;
  int a[n][n],b[n][n];
 
 
  for(int i=0;i<n;i++)//The array is initialized
    {
      for(int j=0;j<n;j++)
	{
	  a[i][j]=(i*10)+j+1;
	  b[i][j]=(j*10)+i+1;
	  
	}
    }
  std:: cout<<"Input the number of threads";
 std::cin>>t;
   std::cout<<'\n';
  
   auto t0 = Time::now();//Initial time is noted
  //The function is run using 1 thread
  if(t==1){
    std:: cout<<"Doing operations for 1 thread\n";
    auto t0 = Time::now();
    std::thread t1 (mul,a,b,p);
    t1.join();
    
  }
  //The function is run using 2 threads
   if(t==2){
     std:: cout<<"Doing operations for 2 threads\n";
    auto t0 = Time::now();
    std::thread t1 (mul,a,b,p);
    std::thread t2 (mul,a,b,p);
   
    t1.join();
    t2.join();
  }
   //The function is run using 3 threads
   if(t==3){
     std:: cout<<"Doing operations for 3 threads\n";
    auto t0 = Time::now();
    std::thread t1 (mul,a,b,p);
    std::thread t2 (mul,a,b,p);
    std::thread t3 (mul,a,b,p);
   
    t1.join();
    t2.join();
    t3.join();
  }//The function is run using 4 threads
   if(t==4){
     std:: cout<<"Doing operations for 4 threads\n";
    auto t0 = Time::now();
    std::thread t1 (mul,a,b,p);
    std::thread t2 (mul,a,b,p);
    std::thread t3 (mul,a,b,p);
    std::thread t4 (mul,a,b,p);
    
    t1.join();
    t2.join();
    t3.join();
    t4.join();
  }
  
 
   tim=((std::chrono::duration_cast<ms>(Time::now()-t0)).count())/(float)1000;//The time for excecuting the code is calculated
   std::cout<<"the time taken ";
  std::cout<<tim;
  std::cout<<"\n";
    
  float i=(n*n);
  
  float io= i/tim;
 
  float iop=io /(float)1000000000;
  iops=iop*8*t*p;
  std::cout<<"the number of Gflops ";
  std::cout<<iops;//the number of GFLOPS is calculated
  std::cout<<"\n";
  
  
  
  
 
}
