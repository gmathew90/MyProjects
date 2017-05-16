import boto.ec2
import boto.sqs
import sys
import boto.dynamodb 
def strt_ec2(n,i,k): #function to start instances
    c= boto.ec2.connect_to_region('us-west-2',aws_access_key_id=i,aws_secret_access_key=k)
    r = c.get_all_reservations()
    lis=[]
    f =open('worker','w') #creating a list of running instances
    for m in r:
        lis.append(m.instances[0].id)
    for m in range(n):
        c.run_instances('ami-9abea4fb',key_name='pa3',instance_type='t2.micro',security_groups=['launch-wizard-1'])
    r = c.get_all_reservations()
    lis2=[]
    lis1=[]
    for m in r:
       lis1.append(m.instances[0].id)
       lis2.append(m.instances[0].public_dns_name)
       print(m.instances[0].public_dns_name)
        
       

    k=len(lis1)-len(lis) #finding the number of instances created
    print ("%d instances started"%k)
    for m in lis2:
    
       f.write(m+'\n') #writing the dnsnames to file
    f.close()
def strt_sqs(nm,i,k): #function to create queue
     c= boto.sqs.connect_to_region('us-west-2',aws_access_key_id=i,aws_secret_access_key=k)
     q = c.create_queue(nm)
     print (c.get_all_queues())

def strt_db(nmd,i,k): #function to create queue
     c=boto.dynamodb.connect_to_region('us-west-2',aws_access_key_id=i,aws_secret_access_key=k) 
     schma=c.create_schema(hash_key_name='id',hash_key_proto_value=str) 
     table = c.create_table(name=nmd,schema=schma,read_units=25,write_units=25)
n=int(sys.argv[1]) #inputs the number of instances
k_id='AXXXXXXXXXXXXXXX'
key='XXXXXXXXXXXXXXXXXXXX'

strt_ec2(n,k_id,key)
nm=sys.argv[2] #inputs the name of instruction queue
strt_sqs(nm,k_id,key)
nm=sys.argv[3] #inputs the name of response queue
strt_sqs(nm,k_id,key)
nmd=sys.argv[4] #inputs the name of db
strt_db(nmd,k_id,key)
