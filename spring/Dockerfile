FROM openjdk:17-alpine as builder
WORKDIR /var/jenkins_home/workspace/whatsub/spring
COPY . .
RUN ./gradlew clean build

FROM openjdk:17-alpine 
COPY --from=builder /var/jenkins_home/workspace/whatsub/spring/build/libs/*.jar whatsub.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "whatsub.jar"]
