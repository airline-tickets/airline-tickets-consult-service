FROM openjdk:8

ADD target/airline-tickets-consult-service.jar airline-tickets-consult-service.jar
EXPOSE 9001
ENTRYPOINT ["java", "-jar", "airline-tickets-consult-service.jar"]