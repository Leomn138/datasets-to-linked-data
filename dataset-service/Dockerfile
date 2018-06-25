FROM java:8-jre
MAINTAINER Leonardo Nascimento <leomn138@gmail.com>

ADD ./target/dataset-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/dataset-service.jar"]

EXPOSE 6000