# Use a lightweight base image with Java 17
FROM eclipse-temurin:17-jdk-alpine

# Copy the Spring Boot executable JAR file into the container
COPY target/*.jar testapp.jar

# Expose the port (if needed)
EXPOSE 8080

# Define the entry point
ENTRYPOINT ["java", "-jar", "testapp.jar"]
