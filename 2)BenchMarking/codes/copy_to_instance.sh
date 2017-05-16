 #!/bin/bash         

scp -i benchmarking.pem  flops.cpp ec2-user@ec2-54-200-26-7.us-west-2.compute.amazonaws.com:~
scp -i benchmarking.pem  iops.cpp ec2-user@ec2-54-200-26-7.us-west-2.compute.amazonaws.com:~
scp -i benchmarking.pem  iops_600.cpp ec2-user@ec2-54-200-26-7.us-west-2.compute.amazonaws.com:~
scp -i benchmarking.pem  flops_600.cpp ec2-user@ec2-54-200-26-7.us-west-2.compute.amazonaws.com:~
scp -i benchmarking.pem  cpu_1.sh ec2-user@ec2-54-200-26-7.us-west-2.compute.amazonaws.com:~
scp -i benchmarking.pem  cpu_2.sh ec2-user@ec2-54-200-26-7.us-west-2.compute.amazonaws.com:~
scp -i benchmarking.pem  xlinpack_xeon64 ec2-user@ec2-54-200-26-7.us-west-2.compute.amazonaws.com:~
scp -i benchmarking.pem  disk.cpp ec2-user@ec2-54-200-26-7.us-west-2.compute.amazonaws.com:~
scp -i benchmarking.pem  disk.sh ec2-user@ec2-54-200-26-7.us-west-2.compute.amazonaws.com:~
scp -i benchmarking.pem  memory.cpp ec2-user@ec2-54-200-26-7.us-west-2.compute.amazonaws.com:~
scp -i benchmarking.pem  memory.sh ec2-user@ec2-54-200-26-7.us-west-2.compute.amazonaws.com:~
scp -i benchmarking.pem  steam.c ec2-user@ec2-54-200-26-7.us-west-2.compute.amazonaws.com:~
scp -i benchmarking.pem  full.sh ec2-user@ec2-54-200-26-7.us-west-2.compute.amazonaws.com:~
