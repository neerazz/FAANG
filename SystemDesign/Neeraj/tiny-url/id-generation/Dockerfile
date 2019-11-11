FROM openjdk:11
EXPOSE 9002:8002
MAINTAINER b.neerajkumarsingh@gmail.com
VOLUME /tmp
ADD build/libs/id-generation-1.0.0-SNAPSHOT.jar id-generation.jar
ENTRYPOINT ["java","-jar","id-generation.jar"]