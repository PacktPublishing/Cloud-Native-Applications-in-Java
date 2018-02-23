FROM openjdk:8-jdk-alpine

RUN mkdir -p /app

ADD target/product.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT [ "/usr/bin/java", "-jar", "/app/app.jar" ]
