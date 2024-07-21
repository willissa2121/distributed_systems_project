# Use an OpenJDK 17 JDK base image from Docker Hub
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container at /app
COPY target/api-gateway-1.0.0.jar app.jar

# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]
