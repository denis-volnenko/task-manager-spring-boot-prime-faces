FROM java:8
COPY ./target/task-manager.war /opt/task-manager.war
WORKDIR /opt

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "task-manager.war"]
