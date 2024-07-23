FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} simpleauth.jar
ENTRYPOINT ["java","-jar","/simpleauth.jar"]