FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/web/target/untitled3.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]