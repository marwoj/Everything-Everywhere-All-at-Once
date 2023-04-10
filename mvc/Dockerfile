FROM eclipse-temurin:19-alpine
COPY build/libs/mvc-0.0.1-SNAPSHOT.jar /opt/app.jar
EXPOSE 8080:8080
CMD ["java", "-Dspring.profiles.active=docker", "-jar", "/opt/app.jar"]