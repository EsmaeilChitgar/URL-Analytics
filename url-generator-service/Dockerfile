FROM openjdk:17-oracle

WORKDIR /app

COPY target/URLGenerator-0.0.1-SNAPSHOT.jar URLGenerator.jar

#EXPOSE 8080

ENTRYPOINT ["java", "-jar", "URLGenerator.jar"]
