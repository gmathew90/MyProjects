# Sort Comparison

### Introduction

The project tries to compare sorting using 3 different methodologies.
- Simple Sort
- Hadoop
- Spark

The following kinds of AWS instances were used.
1)c3.large
2)d2.xlarge
Ubuntu instances were used. SSH, All TCP, All UDP, All ICMP security groups were added to the instances
All instances were updated and java was installed. Raid was used to combine the available hard disk spaces.
Java Version :1.7.0_95
Spot instances were used. c3.large was bid at $0.09 and d2.xlarge was bid at $0.5
The initial Instance was made using d2.xlarge and an AMI image of this was made for future use


### Single Node Sort : External Sorting

10 gb of data was sorted using 3.5 gb of RAM
The sorting was done in 57.3 minutes

### Hadoop

Hadoop was installed and used in pseudo mode and 16 cluster
Hadoop 2.7.2 was downloaded and configured

10 gb data was sorted in pseudo mode using one c3.large system with hadoop
10 GB was sorted in 24.7 minutes
The Hadoop program was run to sort 100gb data
This was completed in 4.39 hours

### Spark

Spark was installed on 17 systems.
1 c3.4large system was used as a master and all other systems were c3.large
The program to sort the entries was written using python
This program was used to sort 10gb in pseudo mode and 100gb in 16 clusters
10 gb of data was sorted using the program on a single node spark system
The sorting was completed in 15 mins
The program was run on this cluster to sort 100gb data
The sorting was completed in 11 mins

### Experiments

Comparison of speed of External sort, Hadoop and Spark to sort 10 GB of data in a single node was done
Comparison of speed of Hadoop and Spark to sort 100 GB of data in a 16 node cluster was done

### Conclusion

It can be concluded that Hadoop is faster than external sort and Spark is faster than Hadoop



