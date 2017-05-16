#!/bin/bash
echo "Generating 10 GB file"
./gensort -a 107000000 input
echo "10GB file generated"
du -h input
javac main.java
java -Xmx2g main
rm input
javac extrnl.java
java -Xmx2g extrnl
du -h Output
echo "Validating the sorted value"
./valsort Output

