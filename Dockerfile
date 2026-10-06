# ---------- Etapa 1: build ----------
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar primero el pom para cachear dependencias
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copiar el código fuente y compilar
COPY src ./src
RUN mvn -B clean package -DskipTests

# ---------- Etapa 2: runtime ----------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Usuario sin privilegios
RUN addgroup -S spring && adduser -S spring -G spring
USER spring

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
