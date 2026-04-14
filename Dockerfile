# FROM eclipse-temurin:17-jdk
# COPY target/loginapp-0.0.1-SNAPSHOT.jar app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]


FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN ./mvnw clean install || mvn clean install

CMD ["java","-jar","target/loginapp-0.0.1-SNAPSHOT.jar"]
