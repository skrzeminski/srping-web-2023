FROM openjdk:17-oracle
MAINTAINER baeldung.com
COPY target/srping-web-2023-0.0.1-SNAPSHOT.jar srping-web-2023-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/srping-web-2023-0.0.1-SNAPSHOT.jar"]