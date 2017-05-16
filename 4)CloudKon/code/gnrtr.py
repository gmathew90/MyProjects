import sys
f =open('wrkr','w')
n=int(sys.argv[1]) #the number of instructions is fetched
st=sys.argv[2]+' '#sys.argv[3] #sleep instruction is fetched
for m in range(n):
   f.write(st+'\n') #written into the file
f.close()
           
