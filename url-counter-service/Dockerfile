FROM openjdk:17-oracle

WORKDIR /app

COPY target/URLCounter-0.0.1-SNAPSHOT.jar URLCounter.jar

#EXPOSE 8080

ENTRYPOINT ["java", "-jar", "URLCounter.jar"]
