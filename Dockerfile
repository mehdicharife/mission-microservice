FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY target/mission-service-0.0.1-SNAPSHOT.jar mission-request-service.jar
ENTRYPOINT ["java", "-jar", "/mission-request-service.jar"]