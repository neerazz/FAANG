FROM openjdk:11
MAINTAINER Neeraj "b.neerajkumarsingh@gmail.com"
COPY :jar tinyurl.jar
ENTRYPOINT ["java"]
CMD ["-jar", "tinyurl.jar"]
EXPOSE 8001
RUN apk --update --no-cache add curl
HEALTHCHECK CMD curl -f http://localhost:8001/health || exit 1
