FROM openjdk:17-alpine as builder
WORKDIR /var/jenkins_home/workspace/whatsub/spring
COPY . .
RUN ./gradlew clean build

FROM openjdk:17-alpine 
COPY --from=builder build/libs/spring-0.0.1-SNAPSHOT.jar whatsub.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "whatsub.jar"]
