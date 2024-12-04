# Primera etapa: construcción
FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app

# Copiar el código fuente del proyecto al contenedor
COPY . .

# Construir el JAR usando Maven
RUN ./mvnw clean package -DskipTests

# Segunda etapa: ejecución
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiar el JAR generado desde la primera etapa
COPY --from=builder /app/target/users2-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto de la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
