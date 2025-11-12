# Imagen base liviana y optimizada
FROM amazoncorretto:21-alpine-jdk

# Directorio de trabajo
WORKDIR /app

# Copia el JAR generado por Maven
COPY target/pawsuscripciones-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto donde corre tu aplicación
EXPOSE 8090

# Ejecuta la app
ENTRYPOINT ["java", "-jar", "app.jar"]
