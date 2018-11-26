FROM openjdk:8-jdk-alpine
RUN apk add curl
VOLUME /tmp
ARG JAR_FILE
COPY /target/${JAR_FILE} app.jar
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n","-Djava.security.egd=file:/dev/./urandom","-jar", "/app.jar"]