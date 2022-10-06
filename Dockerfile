FROM eclipse-temurin:17
ARG JAR_FILE=pabi-pabiUser.jar
ARG JAR_PATH=./
EXPOSE 8300
COPY ${JAR_PATH}${JAR_FILE} pabi-pabiUser.jar
ENTRYPOINT ["java", "-jar", "pabi-pabiUser.jar"]