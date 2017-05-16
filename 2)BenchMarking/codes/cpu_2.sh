 #!/bin/bash         
echo 'Running program to collect 600 IOPS'
g++ -std=c++11 -pthread iops_600.cpp
./a.out
echo 'Running program to find 600 GFLOPS'
g++ -std=c++11 -pthread flops_600.cpp
./a.out
