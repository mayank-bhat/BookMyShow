FROM eclipse-temurin:21-jre

WORKDIR /BookMyShow

COPY target/BookMyShow-0.0.1-SNAPSHOT.jar BookMyShow.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","BookMyShow.jar"]