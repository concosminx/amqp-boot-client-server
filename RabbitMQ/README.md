# Run RabbitMQ on Windows
- download and install ERlang
- download and install RabbitMQ 
- go to RabbitMQ server install directory `C:\Rabbit\sbin`
- run command `rabbitmq-plugins enable rabbitmq_management`
- open browser and enter `http://localhost:15672/` to redirect to RabbitMQ dashboard
- login page default username and password is guest


# Run RabbitMQ on Docker
`docker run -d --hostname my-rabbit --name some-rabbit -e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=password rabbitmq:3-management`
