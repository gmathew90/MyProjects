import boto.sqs
import sys
import os
import boto.dynamodb
import time
qnm=sys.argv[1]

k_id='XXXXXXXXXXXXXXX'
key='XXXXXXXXXXXXXXX'
c= boto.sqs.connect_to_region('us-west-2',aws_access_key_id=k_id,aws_secret_access_key=key)
q = c.create_queue(qnm) #connection to the queue is established
cntr=0;
m=q.get_messages(1)
while(len(m)!=0): #checking whether the queue is empty
   cntr=cntr+1  #counter is incremented 
   q.delete_message(m[0]) #message is deleted
   m=q.get_messages(1) 
print(str(cntr)+' messages with success status found in response queue') 
