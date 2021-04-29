FROM maven:3.6.0-jdk-11-slim AS build

COPY src src
COPY pom.xml .
RUN mvn -f pom.xml clean package install

FROM openjdk:latest
Expose 8080

COPY  --from=build /target/docker-demo.jar docker-demo.jar

RUN ls

CMD ["java", "-jar", "docker-demo.jar"]
