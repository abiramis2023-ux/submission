FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN ./mvnw clean package

CMD ["java", "-cp", "target/feedback-app-1.0.jar", "com.example.Main"]