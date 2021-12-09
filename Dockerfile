FROM maven:3.6.3-openjdk-8
MAINTAINER Denis Volnenko <denis@volnenko.ru>

COPY ./ /opt/task-manager
WORKDIR /opt/task-manager

RUN mvn clean package

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./target/task-manager.war"]
