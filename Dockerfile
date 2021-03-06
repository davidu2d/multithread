FROM adoptopenjdk/openjdk8

EXPOSE 8081

RUN mkdir /opt/app

ADD target/multithread.jar /opt/app

ENTRYPOINT ["java", "-jar", "/opt/app/multithread.jar"]