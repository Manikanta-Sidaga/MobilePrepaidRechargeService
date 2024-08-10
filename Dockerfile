FROM eclipse-temurin:21-jdk AS build
RUN mvn clean package -DskipTests

FROM  openjdk:21-jdk-slim
COPY --from=build /target/MobilePrepaidRechargeService-0.0.1-SNAPSHOT.jar MobilePrepaidRechargeService.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "MobilePrepaidRechargeService.jar"]


