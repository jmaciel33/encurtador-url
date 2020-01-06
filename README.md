#   Encurtador de URL

Plataforma baseada em microserviços para encurtar URLs, com isso é possivel prover a equipe de marketing ferramentas que possibilitem o envio de comunicações por canais de mensageria, tais como SMS e Twitter.

# O problema

O Mercado Livre vem crescendo de maneira muito acelerada nos últimos anos. A experiência do usuário durante a compra e ao grande número de produtos em nosso catálogo são as chaves para entendermos este crescimento. No entanto, não conseguiríamos atingir este patamar sem grandes campanhas de marketing.

Desta forma, queremos prover a equipe de marketing ferramentas que possibilitem o envio de comunicações por canais de mensageria, tais como SMS e Twitter. Nestes canais, é muito importante que as comunicações sejam curtas, assim faz-se necessário o desenvolvimento de um encurtador de URLs.

#  Desenho de solução

![Alt Text](https://github.com/jmaciel33/encurtador-url/blob/master/Encurtador%20URL.png)

 
## Como utilizar?
 
Você possui duas opções, utilizar o docker-compose ou fazer o build de cada componente e executar DBs e RabbitMQ no Docker.

##### 1. Docker Compose :whale:

Antes de execute este comando:

```
$ docker-compose up
```

##### 2. via Maven

```
$ mvn clean install  
```

Containers :whale: 

```
$ docker run --name db-encurtador-1 -p 9042:9042 -d scylladb/scylla  
```
```
$ docker run --name db-encurtador-2 -p 9043:9042 -d scylladb/scylla 
```
```
$ docker run -d -p 15672:15672 -p 5672:5672 -p 25676:25676 rabbitmq:3.7.17-management-alpine  
```



## Casos de teste?

-  POST 


Desafios | URL do MS  | Check
--------- | ------   ------
Dado uma URL longa, ele devolve uma URL curta:    | http://localhost:8081/ms-encurtador-url/encurtador/v1/  | :check:

| Desafios  |  URL do MS  | Métodos |
| ------------------- | ------------------- |------------------- |
|  Dado uma URL longa, ele devolve uma URL curta |  http://localhost:8081/ms-encurtador-url/encurtador/v1/ | POST |
|  Dado uma URL curta, ele devolve  original |  http://localhost:8084/ms-short/encurtador/v1/rq2FP7E | GET |
|  Seja possivel consultar estatíscas dos serviço |  http://localhost:8086/ms-analytics/statistics/v1/ | GET |
|  Apagar URLs  |  http://localhost:8081/ms-encurtador-url/encurtador/v1/ | DELETE |
|  Redirect |  http://localhost:8084/ms-short/v1/| GET |

  [CRia](http://exemplo.com/)



