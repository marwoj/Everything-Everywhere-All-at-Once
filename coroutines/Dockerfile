FROM eclipse-temurin:19-alpine
COPY build/libs/coroutines-0.0.1-SNAPSHOT.jar /opt/app.jar
EXPOSE 8082:8082
CMD ["java", "-Dspring.profiles.active=docker", "-jar", "/opt/app.jar"]