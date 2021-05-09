FROM openjdk:16-alpine

#EXPOSE 8081

ADD out/artifacts/project-0.0.1-SNAPSHOT.jar docker-demo.jar
COPY /upload /upload

ENTRYPOINT ["java","-jar","docker-demo.jar"]