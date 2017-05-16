 #!/bin/bash         
echo 'Running program to find GFLOPS'
g++ -std=c++11 -pthread flops.cpp

./a.out<<'EOF'
1
EOF

./a.out<<'EOF'
2
EOF

./a.out<<'EOF'
4
EOF
echo 'Running Program to find GIOPS'
g++ -std=c++11 -pthread iops.cpp

./a.out<<'EOF'
1
EOF

./a.out<<'EOF'
2
EOF

./a.out<<'EOF'
4
EOF

