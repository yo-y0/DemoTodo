FROM openjdk:21
LABEL maintainer="DemoTodo"
ADD target/todoServer-0.0.1-SNAPSHOT.jar todoServer-docker.jar
ENTRYPOINT ["java", "-jar", "todoServer-docker.jar"]