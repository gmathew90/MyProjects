#!/bin/bash
apt-get update
apt-get install default-jdk
mke2fs -F -t ext4 /dev/xvdc/
mkdir /mnt2
mount /dev/xvdc/ /mnt2
chmod 777 /mnt2
chmod 777 /mnt
cp auto.sh /mnt
cp main.java /mnt
cp extrnl.java /mnt
cp gensort /mnt
cp valsort /mnt
cp main2.java
cp extrnl2.java
