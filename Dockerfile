FROM openjdk:17-jdk-alpine AS build
MAINTAINER immeuble.com
COPY target/immeuble.jar immeuble.jar
ENTRYPOINT ["java","-jar","./immeuble.jar"]