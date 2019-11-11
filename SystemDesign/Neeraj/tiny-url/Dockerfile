FROM openjdk:11
EXPOSE 9001:8001
MAINTAINER b.neerajkumarsingh@gmail.com
VOLUME /tmp
ADD build/libs/tinyurl-1.0.0-SNAPSHOT.jar tinyurl.jar
ENTRYPOINT ["java","-jar","tinyurl.jar"]