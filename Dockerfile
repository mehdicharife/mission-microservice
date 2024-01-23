FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY . /app
WORKDIR /app
RUN mvn package -DskipTests

ENTRYPOINT ["java", "-jar", "target/mission-service-0.0.1-SNAPSHOT.jar"]