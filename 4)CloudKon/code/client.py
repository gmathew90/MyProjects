import boto.sqs
import sys
import os
import random


fnm=sys.argv[2]
qnm=sys.argv[1]
k_id='XXXXXXXXXXXXXXX'
key='XXXXXXXXXXXXXXX'
c= boto.sqs.connect_to_region('us-west-2',aws_access_key_id=k_id,aws_secret_access_key=key)
q = c.create_queue(qnm) #connection to the queue is established
from boto.sqs.message import Message
d=1
with open(fnm) as f :
    for l in f: #instructions are fetched from file
       m=Message()
       m.set_body(str(d)+" "+l)
       print(str(d)+" "+l) #the instructions are combined with id
       print q.write(m)   #this is written into the queue
       d=d+1



