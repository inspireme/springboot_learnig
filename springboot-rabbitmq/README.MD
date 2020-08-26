
#rabbitMQ docker install

docker run -d --hostname my-rabbit --name other-rabbit -p 7070:15672 -p 7071:5672 rabbitmq:3-management