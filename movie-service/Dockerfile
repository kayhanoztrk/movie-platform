FROM openjdk:17.0.1-jdk-slim
WORKDIR /src/movie-service
COPY /target/movie-service-0.0.1-SNAPSHOT.jar movie-service.jar
EXPOSE 8080
CMD ["java","-jar","movie-service.jar"]