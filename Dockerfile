FROM openjdk:8
MAINTAINER github.com/trevoogustavo
COPY target/dryve-carros-0.0.1-SNAPSHOT.jar api.jar
ENTRYPOINT ["java","-jar","/api.jar"]