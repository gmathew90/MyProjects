import os
import boto.dynamodb
import time
import sys
from boto.sqs.message import Message
qnm=sys.argv[1]   #inputs the instruction queue name 
tnm=sys.argv[2]   #inputs the dynamodb name
qnm1=sys.argv[3]  #inputs the response queue name
k_id='XXXXXXXXXXXXXXX'
key='XXXXXXXXXXXXXXX'
c= boto.sqs.connect_to_region('us-west-2',aws_access_key_id=k_id,aws_secret_access_key=key)
q = c.create_queue(qnm)  #connection to the queue is established
q1=c.create_queue(qnm1) #connection to the queue is established
st=time.time()           #start time is noted
m=q.get_messages(1)     #message is fetched
c1=boto.boto.dynamodb.connect_to_region('us-west-2',aws_access_key_id=k_id,aws_secret_access_key=key)
t=c1.get_table(tnm)     #connection to the db is established
data={'value':'Done'}   #data is set
while(len(m)!=0):       #checking whether the queue is empty

   i=(m[0].get_body())
   k=i.split()#the message is split to extract id
   #print (i)
   try:
       t.get_item(hash_key=k[0])  #trying to fetch value from db
   except boto.dynamodb.exceptions.DynamoDBKeyNotFoundError:
       #print "New Item Found"
       item = t.new_item(hash_key =k[0],attrs=data)
       m1=Message()
       m1.set_body(k[0]+" "+"T")
       q1.write(m1) #data put to response queue
       item.put()
       q.delete_message(m[0])
       #delete message from instruction queue
       os.system(k[1]+' '+str(float(k[2])/1000)) 
       #the instruction is executed

   m=q.get_messages(1)
en=time.time()
print(en-st) # the time taken is displayed
