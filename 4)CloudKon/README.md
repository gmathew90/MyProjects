# CloudKon

### Introduction

A distributed task execution framework similar to CloudKon was implemented on Amazon EC2 using SQS and DynamoDB. The framework has two components. One client to push tasks into the SQS and one worker to retrieve works from the SQS and execute them. The Assignment was done using Python

### Client

The client was implemented in python
The client pushes tasks to the SQS and assigns a unique ID for each task

### Local Back End Worker

The worker takes the tasks from SQS, executes them and puts the status in Dynamo DB and Response Queue
The task taken from SQS is taken and checked against the completed tasks in Dynamo DB. The task is executed only if the ID is not there in Dynamo DB

### SQS

SQS ensures message delivery but there could be duplication of messages.So SQS was used for the instruction Queue to ensure that all the tasks are executed

### Dynamo DB

Dynamo DB was used to construct the response Queue to avoid duplication caused by SQS.
The worker fetches the tasks from SQS and executes only if the task is not present in the Response Queue(Dynamo DB)

### Animoto

The above architecture was used to create a system that combines pictures into videos
The animoto generator generates links into a file wrkr. The animoto client takes these values and is populated into the SQS. The worker takes these links from the SQS and then downloads these images. After downloading ffmpeg is used to make a video with this images