# # Stage 1: Build the app using Maven
# FROM maven:3.8.5-openjdk-17-slim AS build

# WORKDIR /app

# # Copy all files
# COPY . .

# # Run Maven to build the project
# RUN mvn clean package -DskipTests

# # Stage 2: Run the app using OpenJDK
# FROM openjdk:17-slim

# WORKDIR /app

# # Copy jar from the previous stage
# COPY --from=build /app/target/*.jar app.jar

# EXPOSE 8080

# ENTRYPOINT ["java", "-jar", "app.jar"]


# Stage 1: Use Maven with JDK 24
FROM maven:3.9.6-eclipse-temurin-24 AS build

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run with JDK 24
FROM eclipse-temurin:24-jdk

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
