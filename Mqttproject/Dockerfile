
FROM openjdk:8
COPY ./target/docker-mqtt-project.jar /docker-mqtt-project.jar
COPY ./pom.xml /pom.xml
EXPOSE 8080
CMD ["java","-jar","/docker-mqtt-project.jar"]

