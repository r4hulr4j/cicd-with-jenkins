FROM adoptopenjdk/openjdk11
WORKDIR /
ADD target/spring-boot-app.jar app.jar
CMD java -jar app.jar