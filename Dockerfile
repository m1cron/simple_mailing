# Build
FROM gradle:7.2-jdk16 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build

# Run
FROM openjdk:16
EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/gradle/src/service/build/libs/*.jar /app/application.jar
ENTRYPOINT ["java", "-jar", "/app/application.jar"]