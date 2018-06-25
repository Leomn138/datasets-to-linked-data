FROM java:8-jre
MAINTAINER Leonardo Nascimento <leomn138@gmail.com>

ADD ./target/transformation-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/transformation-service.jar"]

EXPOSE 6000