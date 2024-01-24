FROM maven:3.8.4-openjdk-17
VOLUME /tmp
COPY . /app
WORKDIR /app
RUN mvn package -DskipTests
ARG SPRING_APPLICATION_JSON
ENV SPRING_APPLICATION_JSON=${SPRING_APPLICATION_JSON}
ENTRYPOINT ["java", "-jar", "target/mission-service-0.0.1-SNAPSHOT.jar"]
