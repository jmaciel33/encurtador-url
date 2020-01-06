#   Encurtador de URL

Plataforma baseada em microserviços para encurtar URLs, com isso é possivel prover a equipe de marketing ferramentas que possibilitem o envio de comunicações por canais de mensageria, tais como SMS e Twitter.


#  Desenho de solução

![Alt Text](https://github.com/jmaciel33/encurtador-url/blob/master/Encurtador%20URL.png)

 
## Como utilizar?
 
Você possui duas opções, utilizar o docker-compose ou fazer o build de cada componente e executar DBs e RabbitMQ no Docker.

##### 1. Docker Compose

Antes de execute este comando:

```
$ docker-compose up
```

##### 2. via Maven

```
$ mvn clean install  
```

Containers: 

```
$ docker run --name db-encurtador-1 -p 9042:9042 -d scylladb/scylla  
```
```
$ docker run --name db-encurtador-2 -p 9043:9042 -d scylladb/scylla 
```
```
$ docker run -d -p 15672:15672 -p 5672:5672 -p 25676:25676 rabbitmq:3.7.17-management-alpine  
```
