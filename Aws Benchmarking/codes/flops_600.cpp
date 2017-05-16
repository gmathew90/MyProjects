/*
Done by George Mathew
as part of cloud computing assignment 1:Benchmarking
CPU Benchmarking:FLOPS calculation(600 instances)
Program to measure the CPU Processing speed in FLOPS

 */

#include<iostream>
#include<time.h>
#include<stdlib.h>
#include<thread>
#include <fstream>
void  mul()//function that will be run to calculate the flops
{
  float a=(float)3/(float)2;
  a=(float)3+(float)2;
  a=(float)3-(float)2;
  a=(float)3*(float)2;
}
int  main()
{
  
  typedef std::chrono::high_resolution_clock Time;
  typedef std::chrono::milliseconds ms;
  typedef std::chrono::duration<float> fsec;
  auto t0 = Time::now();
  float a;
  float arr[600];
  float cnt=0;
  int cnt_6=0;
  while(cnt_6<600)// the code inside is run 600 times
    {
      cnt=0;
   auto t0 = Time::now();
  while((std::chrono::duration_cast<ms>(Time::now()-t0)).count()<1000)//Time is checked on each iteration and if it becomes 1 sec it exits and cnt stores the number of iterations
    {
    std::thread t1 (mul);
    std::thread t2(mul);
    std::thread t3(mul);
    std::thread t4(mul);
    t1.join();
    t2.join();
    t3.join();
    t4.join();
    cnt=cnt+float(1);
	  
    
 
    
}
auto t1 = Time::now();
fsec fs = t1 - t0;
ms d = std::chrono::duration_cast<ms>(fs);

a=(float)cnt*1000*4*7/d.count();
 std::cout<<a<<'\n';//The number of operations in one second is displayed and stored in an array
 
 arr[cnt_6]=a;
 cnt_6++;
    }
  std::ofstream myfile;// the array is written to a file
  myfile.open ("flops_600.txt");
  for(int m=0;m<600;m++)
    {
      
      myfile <<arr[m];
      myfile<<'\n';
      
    }
  myfile.close();
  return 0;
}
