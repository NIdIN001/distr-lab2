FROM  bellsoft/liberica-openjdk-alpine:17.0.5
MAINTAINER  Utochkin Stanislav <utochkins@bk.ru>

COPY target/worker-1.0.0.jar app/worker-1.0.0.jar
ENTRYPOINT ["java","-jar","app/worker-1.0.0.jar", "--spring.config.location=/app/config/application.yml"]

