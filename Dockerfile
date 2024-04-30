# syntax=docker/dockerfile:1
# Sử dụng một ảnh base chứa JDK để chạy ứng dụng Spring Boot
FROM openjdk:23-oraclelinux9


# Tác giả của Dockerfile
#LABEL maintainer="Your Name <your.email@example.com>"

# Tạo thư mục /app trong container
RUN mkdir /app

# Di chuyển vào thư mục /app làm thư mục làm việc mặc định
WORKDIR /app

# Sao chép file JAR của ứng dụng Spring Boot vào thư mục /app trong container
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
#run this inside the image
RUN ./mvnw dependency:go-offline
COPY src ./src
# run inside container
CMD ["./mvnw","spring-boot:run"]


# Mở cổng mà ứng dụng sẽ chạy trên
#EXPOSE 8080

# Command để chạy ứng dụng Spring Boot khi container được khởi động
#CMD ["java", "-jar", "your-application.jar"]
