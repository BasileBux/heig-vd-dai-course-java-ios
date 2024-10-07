# Base image
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/java-ios-1.0-SNAPSHOT.jar /app/java-ios-1.0-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "java-ios-1.0-SNAPSHOT.jar"]

CMD ["--help"]
