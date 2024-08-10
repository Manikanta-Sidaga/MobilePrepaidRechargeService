# Use an official Maven image to build the application
FROM maven:3.8.7-eclipse-temurin-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file and install dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copy the entire project source code into the container
COPY src ./src

# Build the Spring Boot application
RUN mvn clean package -DskipTests

# Use a minimal Java 21 runtime image to run the application
FROM eclipse-temurin:21-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the previous build stage
COPY --from=build /app/target/*MobilePrepaidRechargeService.jar app.jar

# Expose the port the application will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
