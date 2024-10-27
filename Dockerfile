FROM openjdk:17
WORKDIR /app
COPY ./target/ms-exchange-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ms-exchange-0.0.1-SNAPSHOT.jar"]