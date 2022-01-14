<<<<<<< HEAD
FROM java:8-jdk-alpine

COPY /target/recApp-0.0.1-SNAPSHOT.jar /recApp.jar

=======
FROM java:8-jdk-alpine

COPY /target/recApp-0.0.1-SNAPSHOT.jar /recApp.jar

>>>>>>> 5f279ef36273302d738d10e7da193d2df6b7230c
CMD ["java","-jar","recApp.jar"]