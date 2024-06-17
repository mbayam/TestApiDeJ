# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file to the container
COPY target/test-analyste-programmeur-0.0.1-SNAPSHOT.jar /app/test-analyste-programmeur-0.0.1-SNAPSHOT.jar

# Expose port 8080
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "test-analyste-programmeur-0.0.1-SNAPSHOT.jar"]
