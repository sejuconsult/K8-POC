FROM openjdk:8-jdk-alpine
RUN apk add curl
VOLUME /tmp
ARG JAR_FILE
COPY /target/${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar", "/app.jar"]