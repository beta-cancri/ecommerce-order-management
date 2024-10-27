# Use the official OpenJDK image as a base
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file
COPY build/libs/ecommerce-0.0.1-SNAPSHOT.jar app.jar

# Copy the resources folder (application.properties and schema.sql) into the container
COPY src/main/resources /app/resources

# Expose the port your Spring Boot application will run on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
