FROM maven:3.8.4-openjdk-11
VOLUME /tmp
COPY . /app
WORKDIR /app
RUN mvn package -DskipTests

ENTRYPOINT ["java", "-jar", "target/mission-service-0.0.1-SNAPSHOT.jar"]