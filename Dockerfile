FROM maven:3.9.1-eclipse-temurin-20 as builder
COPY . /app
WORKDIR /app
RUN mvn clean package

FROM eclipse-temurin:20-jre

COPY --from=builder /app/consumer/target/*.jar /app/consumer.jar
COPY --from=builder /app/provider/target/*.jar /app/provider.jar
COPY --from=builder /app/service/target/*.jar /app/service.jar

ENTRYPOINT java -jar --module-path /app:/app/lib/service.jar:app/lib/consumer.jar:app/lib/provider.jar --module org.example.consumer/org.example.consumer.Consumer
