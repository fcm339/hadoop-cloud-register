#基于java8镜像
FROM java:8

VOLUME /tmp
#复制本地jar到容器的根目录，并重命名为app.jar
ADD /target/hadoop.jar /register.jar
COPY ../start.sh /
RUN bash -c 'touch /register.jar'

EXPOSE 8888

ENTRYPOINT ["sh","/start.jar"]
#运行 docker build -t register:0.0.01 .