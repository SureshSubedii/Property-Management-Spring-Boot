FROM openjdk:23-jdk-slim
WORKDIR /app
COPY target/*.jar /propertymanagement-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "/propertymanagement-0.0.1-SNAPSHOT.jar"]
