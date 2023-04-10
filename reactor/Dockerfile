FROM eclipse-temurin:19-alpine
COPY build/libs/reactor-0.0.1-SNAPSHOT.jar /opt/app.jar
EXPOSE 8081:8081
CMD ["java", "-Dspring.profiles.active=docker", "-jar", "/opt/app.jar"]