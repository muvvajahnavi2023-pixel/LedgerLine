# Use official OpenJDK image as base
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy maven wrapper and pom file
mvnw pom.xml ./
COPY .mvn .mvn
COPY mvnw pom.xml ./
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Run the jar file
CMD ["java", "-jar", "target/ledgerline-0.0.1-SNAPSHOT.jar"]