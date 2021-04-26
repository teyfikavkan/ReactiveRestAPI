FROM java:8-jdk-alpine

MAINTAINER TeyfikAvkan

COPY ./target/reactive-rest-api-0.0.1-SNAPSHOT.jar /usr/app/reactive-rest-api-0.0.1-SNAPSHOT.jar

WORKDIR /usr/app

RUN sh -c 'touch reactive-rest-api-0.0.1-SNAPSHOT.jar'

EXPOSE 8080

EXPOSE 27017

ARG JAR_FILE=target/reactive-rest-api-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","reactive-rest-api-0.0.1-SNAPSHOT.jar"]