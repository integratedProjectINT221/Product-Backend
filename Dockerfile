FROM openjdk:11-alpine

EXPOSE 8081

ADD out/artifacts/project-0.0.1-SNAPSHOT.jar docker-demo.jar

ENTRYPOINT ["java","-jar","docker-demo.jar"]