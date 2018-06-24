FROM java:8-jre
MAINTAINER Leonardo Nascimento <leomn138@gmail.com>

ADD ./target/registry.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/registry.jar"]

EXPOSE 8761