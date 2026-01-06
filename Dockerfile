# =========================
# build
# =========================
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /build

# Copiamos solo lo necesario primero (mejora cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el código
COPY src ./src

# Construimos el JAR
RUN mvn clean package -DskipTests


# =========================
# 2️⃣ runtime
# =========================
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copiamos el JAR generado
COPY --from=build /build/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
