# Utilisez une image de base Java
FROM openjdk:26-ea-jdk-slim

# Définissez le répertoire de travail dans le conteneur
WORKDIR /app

# Copiez le fichier JAR dans le conteneur
COPY target/*.jar app.jar

# Exposez le port utilisé par l'application Spring Boot
EXPOSE 8084

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
