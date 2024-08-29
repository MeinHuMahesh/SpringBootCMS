FROM maven:3.8.3-openjdk-17 AS builder
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
EXPOSE 9090
COPY wait-for-it.sh /app/wait-for-it.sh
RUN chmod +x /app/wait-for-it.sh
COPY --from=builder /app/target/  .
CMD ["sh", "-c", "/wait-for-it.sh mysql_container:3306 -- java -jar course-management-docker.jar"]

