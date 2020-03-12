#基于java8镜像
FROM centos:latest
MAINTAINER zhongliang.hunag

RUN yum install -y java-1.8.0-openjdk.x86_64 java-1.8.0-openjdk-devel wget net-tools
#安装相应的支持的软件包,openssh-server/clients 和 sudo
RUN yum install -y openssh-server sudo

ENV JAVA_HOME /usr/lib/jvm/java-1.8.0
ENV PATH $JAVA_HOME:$PATH
ENV JRE_HOME $JAVA_HOME/jre
ENV PATH $PATH:$JAVA_HOME/bin:$JRE_HOME/bin

ADD hadoop-3.2.1.tar.gz /usr/local
RUN mv /usr/local/hadoop-3.2.1 /usr/local/hadoop
ENV HADOOP_HOME /usr/local/hadoop
ENV PATH $HADOOP_HOME/bin:$PATH

RUN sed -i 's/UsePAM yes/UsePAM no/g' /etc/ssh/sshd_config
RUN yum install -y openssh-clients
#添加相应的镜像系统下的root用户，这个是必须的操作
RUN echo "root:root" | chpasswd
RUN echo "root ALL=(ALL)    ALL" >> /etc/sudoers

#给SSH生成密钥对
RUN ssh-keygen -t dsa -P '' -f /etc/ssh/ssh_host_dsa_key
RUN ssh-keygen -t rsa -P '' -f /etc/ssh/ssh_host_rsa_key

RUN mkdir /var/run/sshd

RUN ssh-keygen -t rsa -P '' -f ~/.ssh/id_rsa


EXPOSE 22

CMD [ "/usr/sbin/sshd","-D"]

#运行生成镜像 docker build -t hadoop:1.0 .

#生成容器并进入 docker run -itd --name hadoopdatenode hadoop:1.0

#进入容器docker exec -i -t a18b79b4639d /bin/sh

#exit退出容器 cat /etc/ssh/ssh_host_rsa_key.pub>>/etc/ssh/authorized_keys

#ssh-copy-id -i /etc/ssh/ssh_host_rsa_key.pub localhost


