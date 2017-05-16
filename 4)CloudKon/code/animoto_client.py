import boto.sqs
import sys
import os
import random


fnm=sys.argv[2] #takes the file name as command line arguement
qnm=sys.argv[1] #takes the queue name as command line arguement
k_id='XXXXXXXXXXXXXXX'
key='XXXXXXXXXXXXXXX'
c= boto.sqs.connect_to_region('us-west-2',aws_access_key_id=k_id,aws_secret_access_key=key)
q = c.create_queue(qnm)    #establishes connection to the queue
from boto.sqs.message import Message
d=1
with open(fnm) as f :
    for l in f:
       m=Message()
       m.set_body(str(d)+" "+l) #makes a message with instruction
       print(str(d)+" "+l)
       print q.write(m)      #writes the message to the queue
       d=d+1
