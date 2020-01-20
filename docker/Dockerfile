#基于java8镜像
FROM java:8

VOLUME /tmp
#复制本地jar到容器的根目录，并重命名为aap.jar
ADD /target/hadoop.jar /app.jar

RUN bash -c 'touch /app.jar'

EXPOSE 8888

ENTRYPOINT ["java","-Djava-security.egd=file:/dev/./urandom","-jar","/app.jar"]
#运行 docker build -t register:0.0.01 .