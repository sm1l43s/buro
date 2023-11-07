FROM gradle:7.4.0-jdk17 AS build
COPY . .
RUN gradle clean build -Pprod -x test

FROM openjdk:21-ea-17-slim-buster
COPY --from=build /target/0.0.1-SNAPSHOT.jar buro.jar

## ENV PORT=8080
EXPOSE 8080
ENTRYPOINT["java","-jar","buro.jar"]