FROM maven:3-jdk-8
MAINTAINER Denis Volnenko <denis@volnenko.ru>

COPY ./ /opt/task-manager
WORKDIR /opt/task-manager

RUN mvn clean package

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./target/task-manager.jar"]
