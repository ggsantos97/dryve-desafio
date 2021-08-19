FROM openjdk:8
COPY target/dryve-carros-0.0.1-SNAPSHOT.jar api-server.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar","/api-server.jar"]