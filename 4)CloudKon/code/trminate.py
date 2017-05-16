import boto.ec2
import boto.sqs

def trm_ec2(i,k):
    c= boto.ec2.connect_to_region('us-west-2',aws_access_key_id=i,aws_secret_access_key=k)
    r = c.get_all_reservations() 
    #fetches all the running instances
    lis=[]
    for m in r:
        lis.append(m.instances[0].id)
    print(c.terminate_instances(instance_ids=lis))
    #terminates all running instances
    c= boto.sqs.connect_to_region('us-west-2',aws_access_key_id=i,aws_secret_access_key=k)
    lis=c.get_all_queues() #getting list of running queues
    for m in lis:
       m.delete()#closinng all the queues
       


k_id='XXXXXXXXXXXXXXXXXX'
key='XXXXXXXXXXXXXXXXXXXXXXXX'
print(trm_ec2(k_id,key))
