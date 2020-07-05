# spingboot-udev

## Plugin IDE

 - Use lombok

Sping Boot 2 example BOOK API projet (list books, add books, find by author, ...)

 - Build and run with open jdk 13 (https://openjdk.java.net/, https://jdk.java.net/13/) min jdk 8, see <java.version> maven property
 - 3 REST controllers, see : package `com.example.demo.controller`
 - BookController use service, spring data with H2 mem DB (see `application.properties` file)
 - To changhe api port see application.properties

Get project : `git clone https://github.com/cgi-paris-fs-comex/udev-springboot.git`

## Build

 - `mvn clean install` (or use maven wrapper : ./mvnw clean install or build and run with ./mvnw spring-boot:run)
 - See pom for unpack maven dependencies
 - OPTIONAL: Image : near Dockerfile launch `docker build --no-cache -t bookapp_image:1.0.0 .` (with 13-jdk-alpine)
 
## Swagger IU

 - http://localhost:8080/api/swagger-ui.html (https://swagger.io/)
 
## Run with docker OPTIONAL

 - `docker run -d --name appbook_micro1 -p 8080:8080 bookapp_image:1.0.0` (Detached (-d), without to see terminal log)
 
## Other docker commands

 - `docker container ls --all` list containers (or `docker ps`)
 - `docker images` list images
 - `docker container stop appbook_micro1` stop container
 - `docker rm appbook_micro1` remove container
 - `docker rmi <id-image>` remove image
 - `docker network rm <NETWORK>` remove one or more networks
 
# DB H2

 - In the same container than the app
 - See http://localhost:8080/api/h2-console/ (with JDBC URL : `jdbc:h2:mem:testdb`), to prevent H2 Console throwing a error webAllowOthers, must set `spring.h2.console.settings.web-allow-others` to true
 - See src/main/resources/db/runtime.sql for add data at start-up


# REDIS cache OPTIONAL

 - Only with !dev spring profile (dev mode use spring NoOpCacheManager)
 - With docker container
 - With Jedis java client (https://redis.io/clients#java, https://github.com/xetorthio/jedis)


See https://medium.com/@jaaq/making-docker-containers-talk-to-each-other-by-hostname-using-container-networking-94835a6f6a5b to connect different docker containers. Here we don't use Docker Compose.

```
docker network list
docker network create myNetwork
docker network list
docker pull redis
docker run --name my-redis-container -d -p 6379:6379 --network myNetwork redis:latest
docker run --name appbook_micro1 -p 8080:8080 --network myNetwork bookapp_image:1.0.0
```

`docker network inspect myNetwork` to see containers connected to our network. See https://docs.docker.com/network/ pour more info.

 - Connection to container with bash : `docker exec -it my-redis-container /bin/bash`
 - Test `redis-cli` (https://redis.io/topics/quickstart)


## Test

 - http://localhost:8080/api/swagger-ui.html
 
 
Or use for instance Postman to test the REST services https://www.getpostman.com/downloads/ ... must add some books first.

POST http://localhost:8080/api/books

with payload :
```
{
	"title": "LOTR 1",
	"author": "toto"
}
```

GET http://localhost:8080/api/books/

GET http://localhost:8080/api/books/1

GET http://localhost:8080/api/books/author/toto
