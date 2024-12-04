# Imagen base de OpenJDK para Java 17 (puedes ajustarla si usas otra versión)
FROM eclipse-temurin:17-jdk-alpine

# Establecer un directorio de trabajo
WORKDIR /app

# Copiar el JAR generado al contenedor
COPY target/users2-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que tu aplicación Spring Boot está configurada (por defecto 8080)
EXPOSE 8080

# Comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
