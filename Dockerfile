# Stage 1: Build the Java Gradle application
FROM gradle:latest AS build

# Set the working directory inside the container
WORKDIR /home/gradle/src

# Copy the contents of the current directory into the container
COPY --chown=gradle:gradle . .

# Build the Java Gradle application (without using the Gradle daemon)
RUN gradle clean build --no-daemon

# Stage 2: Create the runtime image
FROM openjdk:17

# Expose port 8080 to the host machine
EXPOSE 8080

# Create a directory named /app inside the container
RUN mkdir /app

# Copy the built JAR file from the previous build stage to the /app directory inside the container
COPY --from=build /home/gradle/src/build/libs/your-application.jar /app/app.jar

# Set the entry point for the container to run the Java application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]