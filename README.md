# Getting Started
**Spring Boot JMS ActiveMQ Producer and Consumer** 
This template will help to know about Spring Boot JMS ActiveMQ Producer and Consumer Example from scratch.
We will create consumer and producer class as REST end points.

**Requirements**
> JDK 1.8 or more download
> Download and Install ActiveMQ.

Steps to test your application as given under:
> Login to ActiveMQ console >(http://localhost:8161/admin/) 
> Type the credentials as username="admin" and password="admin".
> Open postman and use below URL to send the message.
        http://localhost:9091/produce/message
RequestData
{
"studentId": "20",
"name": "rakesh",
"rollNumber": "0126CS01"
}      

>On ActiveMq console, click on Queue.
> We should able to see message under Names row as "camelConsumerExample-One"

Open Postman again, and hit the url given below for consumer:
> http://localhost:9091/consume/message
> Check activeMq console, you can see the no of pending messages will be consumed.