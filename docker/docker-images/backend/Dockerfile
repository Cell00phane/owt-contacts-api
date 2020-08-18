FROM openjdk:8-jdk-alpine
#
# Alpine docker image doesn't have bash installed by default
#
RUN apk update && apk add bash

COPY contacts-api-0.0.1-SNAPSHOT.jar /opt/app/server-contacts.jar

COPY wait-for-it.sh /

EXPOSE 8080
