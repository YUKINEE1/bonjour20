FROM openjdk:17-jre-slim
WORKDIR /app
COPY target/bonjour21.jar /app/app.jar
EXPOSE 8084

ENTRYPOINT ["java", "-jar","app.jar"]