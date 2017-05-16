 #!/bin/bash         
echo 'Running program to do disk benchmarking'
g++ -std=c++11 -pthread disk.cpp

./a.out<<'EOF'
1
1
EOF

./a.out<<'EOF'
1
2
EOF

./a.out<<'EOF'
2
2
EOF

./a.out<<'EOF'
3
1
EOF

./a.out<<'EOF'
3
2
EOF

./a.out<<'EOF'
4
1
EOF

./a.out<<'EOF'
4
2
EOF

./a.out<<'EOF'
5
1
EOF

./a.out<<'EOF'
5
2
EOF

./a.out<<'EOF'
6
1
EOF

./a.out<<'EOF'
6
2
EOF

