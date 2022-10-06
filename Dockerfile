FROM eclipse-temurin:17
ARG JAR_FILE=pabi-user.jar
ARG JAR_PATH=./
EXPOSE 8300
COPY ${JAR_PATH}${JAR_FILE} pabi-user.jar
ENTRYPOINT ["java", "-jar", "pabi-user.jar"]