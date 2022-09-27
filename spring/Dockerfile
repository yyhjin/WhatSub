FROM openjdk:17-alpine
WORKDIR /var/jenkins_home/workspace/whatsub/spring
COPY . .
CMD ["./gradlew", "clean", "build"]
ARG JAR_FILE_PATH=build/libs/spring-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE_PATH} whatsub.jar
ENTRYPOINT ["java", "-jar", "whatsub.jar"]
