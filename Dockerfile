LABEL authors="Nelson Ruiz M."

# Etapa 1: Construcción
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copiar archivos de Maven y el POM
COPY pom.xml ./
COPY .mvn/ .mvn
COPY mvnw ./

# Dar permisos al script de Maven Wrapper
RUN chmod +x mvnw

# Descargar dependencias necesarias
RUN ./mvnw dependency:go-offline

# Copiar el código fuente y construir la aplicación
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagen final
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copiar el JAR desde la etapa de construcción
COPY --from=build /app/target/screen_time-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto de la aplicación
EXPOSE 8080

# Comando de inicio
ENTRYPOINT ["java","-jar","app.jar"]
