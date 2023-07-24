# Stage 1: Build the Java Gradle application
FROM docker.io/library/gradle:8.2.1-jdk8-alpine AS build

# Set the working directory inside the container
WORKDIR /home/gradle/src

# Copy the contents of the current directory into the container
# The .dockerignore file should be used to exclude unnecessary files from the build context
COPY --chown=gradle:gradle . .

# Build the Java Gradle application (without using the Gradle daemon)
RUN gradle build --no-daemon

# Stage 2: Create the runtime image
FROM openjdk:11

# Expose port 8080 to the host machine
EXPOSE 8080

# Create a directory named /app inside the container
RUN mkdir /app

# Copy the built JAR file from the previous build stage to the /app directory inside the container
COPY --from=build /home/gradle/src/build/libs/*.jar /app/app.jar

# Set the entry point for the container to run the Java application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]