# Base JDK image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the jar file (replace with your jar name if fixed)
COPY target/*.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]