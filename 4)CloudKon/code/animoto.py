import random
import sys
import os
f =open('wrkr','w') #opens the file wrkr for writing
n=int(sys.argv[1])  #takes in the no of workers as command line
for m in range(160*n):#loop to generate the links
   f.write("http://dummyimage.com/1920x1680/"+str(m*100)+"/img"+str(m)+".jpg\n")
