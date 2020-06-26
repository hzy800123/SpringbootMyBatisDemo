FROM openjdk:latest

ADD target/springboot-package.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 9090
