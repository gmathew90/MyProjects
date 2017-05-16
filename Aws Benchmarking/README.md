# AWS Bench Marking

There are three sections to the assignment:

1)CPU

2)Memory

3)Disk

If all the experiments have to be run together the following command has to be run

```sh
$./full.sh
```

### CPU

CPU has two parts

- The GIOPS and FLOPS calculation:
	- This experiment is to compute GFLOPS and GIOPS
	- This is done by two programs. Iops.cpp and flops.cpp
	- This experiment can be run by running the following command
```sh
$ ./cpu_1.sh
```
- The 600 sample program:
	- This experiment is to do integer and float operations for 10 minutes and produce 600 IOPS samples and 600 FLOPS samples
	- This is done by two programs.iops_600.cpp and flops_600.cpp
	- This experiment can be run by running the following command
```sh
$ ./cpu_2.sh
```

### Memory
- This experiment consists of 6 functions that do sequential and random memory access using 1B,1KB and 1MB block size
- This experiment is run by the program memory.cpp
- This can be run by the following command

```sh
$./memory.sh
```

### Disk
- This is experiment does read,write and seek operations using 1B, 1KB and 1MB block size with random and sequential read and write operations
- This experiment is run by the program disk.cpp
- This can be run by the following command
```sh
$./disk.sh
```


