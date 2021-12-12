# Order Service

## Requirements
For building and running the application you need:

- [JDK 11](https://jdk.java.net/archive/)
- [Maven 3+](https://maven.apache.org)
- [Docker](https://maven.apache.org) (For containerization)

## Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.atilayakkan.assignment.orderservice.OrderServiceApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Deploying the application as Docker Image

To deploy the application as Docker Image you need to build an image out of project:

```shell
docker build -t order-service.jar
```

In order to see created image in the list:
```shell
docker image ls
```

After that you can run the application with following command:

```shell
docker run -d --name orderservice -p 8080:8080 order-service.jar
```