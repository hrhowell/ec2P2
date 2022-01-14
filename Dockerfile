FROM java:8-jdk-alpine

COPY /target/recApp-0.0.1-SNAPSHOT.jar /recApp.jar

CMD ["java","-jar","recApp.jar"]