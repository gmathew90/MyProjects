import time
import threading
import sys

th=sys.argv[1] #number of threads is read
def tim(i,nm): #function that executes the instruction
    print (nm+ ' Thread')
    print ('sleep '+str(i))
    time.sleep(float(i)/1000.00)

    

q=[]
r=[]
i=0
with open ('wrkr') as f: #instructions are read into a list
    for l in f:
        q.append(l.strip())
st=time.time()  #start time is noted
while(i<len(q)): #looping till the end of list
    dic={}
    for n in range(int(th)):
       if(i<len(q)):
          #pool of threads is created
          m=q[i]
          dic[n] = threading.Thread(target=tim, args=(int(m.split()[1]),str(n),))
          dic[n].start() #all the threads are started
          dic[n].join()
          i=i+1
          r.append(m) #instructions put into second list
en=time.time()
print ("Time Taken: "+str(en-st)) #displaying the time taken
print (str(len(r))+" messages with success status found in response Queue")
