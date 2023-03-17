FROM  bellsoft/liberica-openjdk-alpine:17.0.5
MAINTAINER  Utochkin Stanislav <utochkins@bk.ru>

COPY target/manager-1.0.0.jar app/manager-1.0.0.jar
ENTRYPOINT ["java","-jar","app/manager-1.0.0.jar", "--spring.config.location=/app/config/application.yml"]

