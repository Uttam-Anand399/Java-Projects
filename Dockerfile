# Base image
FROM openjdk:17-jdk-slim

# JAR file copy karna (replace jar name if needed)
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Run the jar
ENTRYPOINT ["java","-jar","/app.jar"]
