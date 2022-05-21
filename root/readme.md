# Let's build a load balancer

This workshop aims to compare 3 common load balancing algorithms, highlighting their main characteristics and pointing out where they are suitable and where they aren't. Let's begin.  



## Rules:
To distribute traffic across your application servers you will need a load balancer. In this lab you will create different types of Application Load Balancer.  
1. A server type can be lazy, eager, or normal  
1. Time spent on a task can be lazy, eager, or normal

## Implementation
### use case 1 (example) -  Round Robin Load Balancer  
For usecase 1 let's assume identical server types  + identical tasks processing time.  

Round Robin is undoubtedly the most widely used algorithm. It's easy to implement and easy to understand. Here's how it works. Let's say you have 2 servers waiting for requests behind your load balancer. Once the first request arrives, the load balancer will forward that request to the 1st server. When the 2nd request arrives (presumably from a different client), that request will then be forwarded to the 2nd server. The Round Robin algorithm is best for clusters consisting of servers with identical specs. 

### use case 2 (yours)
Assums identical server types but different tasks process time  
You should implement UseCase2LoadBalancer.handleRequest method. Which LoadBalancer algorithm is appropriate in this case? How long does it take to complete all the tasks?  

### use case 3 (yours)
Taking into account different server types, as well as tasks processing time
You should implement UseCase3LoadBalancer.handleRequest method. Which LoadBalancer algorithm is appropriate in this case? How long does it take to complete all the tasks?


## Execution
For each use case, just run "main" method, e.g. for use-case 1, run UseCase1.java -> main
