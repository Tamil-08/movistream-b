# Stage 1: Build the app using Maven
FROM maven:3.8.5-openjdk-17-slim AS build

WORKDIR /app

# Copy all files
COPY . .

# Run Maven to build the project
RUN mvn clean package -DskipTests

# Stage 2: Run the app using OpenJDK
FROM openjdk:17-slim

WORKDIR /app

# Copy jar from the previous stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
