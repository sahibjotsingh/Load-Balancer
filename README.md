# Load Balancer
This is a demo application which creates all 5 servers, loadbalancer and client(s) that are localhost only.

## Features
The load balancer:
  * Dispatches requests to a group of servers in a Round-Robin fashion (every request is forwarded to a different route in a circular order)
  * Provides the flexibility to add or subtract servers as demand dictates

## Sample Run
1. First run all servers and the load balancer.
2. Run the client(s). Write a number and click on send button.
