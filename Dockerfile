# Use Java 11 for the runtime
FROM openjdk:11

# Expose port 8080 to the host machine
EXPOSE 8080

# Create a directory named /app inside the container
RUN mkdir /app

# Copy the built JAR file with dependencies to the /app directory inside the container
COPY build/libs/Week3IP-WildLifeTrackerApplication-1.0-SNAPSHOT.jar /app/app.jar

# Set the entry point for the container to run the Java application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]