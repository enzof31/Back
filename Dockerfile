
FROM amazoncorretto:11-alpine-jdk
MAINTAINER Enzof
COPY target/enzo-0.0.1-SNAPSHOT.jar enzo-app.jar
ENTRYPOINT ["java","-jar","/enzo-app.jar"]