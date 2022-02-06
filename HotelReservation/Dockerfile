FROM maven:3.8.4-openjdk-17-slim AS BUILDER
ARG VERSION=0.0.1-SNAPSHOT
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src
RUN mvn clean package
COPY target/demo-${VERSION}.jar target/application.jar


FROM openjdk:17-slim-buster
WORKDIR /app/
COPY --from=BUILDER build/target/application.jar /app
CMD java -jar  /app/application.jar
