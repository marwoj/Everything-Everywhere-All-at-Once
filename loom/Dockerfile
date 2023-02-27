FROM eclipse-temurin:19-alpine
COPY build/libs/loom-0.0.1-SNAPSHOT.jar /opt/app.jar
EXPOSE 8083:8083
CMD ["java", "-Dspring.profiles.active=docker", "--enable-preview", "-jar", "/opt/app.jar"]