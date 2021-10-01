# Build
FROM gradle:7.2-jdk16 AS build
WORKDIR /tmp/
COPY . .
RUN gradle clean build

ARG APP_NAME
ENV APP_NAME=$APP_NAME

COPY --from=build /tmp/service/build/libs/${APP_NAME}*.jar /tmp/${APP_NAME}.jar

# Run
FROM openjdk:16
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/tmp/${APP_NAME}.jar"]