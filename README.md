# Load Balancer
This is a demo application which creates all 5 servers, loadbalancer and client(s) that are localhost only.

## Features
The load balancer:
  1. Dispatches requests to a group of servers in a Round-Robin fashion (every request is forwarded to a different server in a circular order)
  2. Provides the flexibility to add or subtract servers as demand dictates

## Sample Run
1. First run all servers and the load balancer.
2. Run the client(s). Write a number and click on send button.

## Suggested Work
I didn't work much on this application since 2-3 months. However I thought of the following todo :
 1. Make the load balancer return the IP address and port number of the server.
 2. The client connection then gets established directly with the server.



