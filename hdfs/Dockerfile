#基于java8镜像
FROM centos:latest
MAINTAINER zhongliang.hunag

RUN yum install -y java-1.8.0-openjdk.x86_64 java-1.8.0-openjdk-devel wget
cd
ENV PATH /usr/bin/java:$PATH

ADD hadoop-3.2.1.tar.gz /usr/local
#RUN tar -zxvf hadoop-3.2.1.tar.gz -C /usr/local/
RUN mv /usr/local/hadoop-3.2.1 /usr/local/hadoop
ENV HADOOP_HOME /usr/local/hadoop
ENV PATH $HADOOP_HOME/bin:$PATH

#安装相应的支持的软件包,openssh-server/clients 和 sudo
RUN yum install -y openssh-server sudo
#给SSH生成密钥对
RUN ssh-keygen -t dsa -f /etc/ssh/ssh_host_dsa_key
RUN ssh-keygen -t rsa -f /etc/ssh/ssh_host_rsa_key
RUN mkdir -p /root/.ssh
#ADD authorized_keys /root/.ssh/authorized_keys
#启用sshd服务并且暴露相关的端口信息
RUN mkdir /var/run/sshd
# 禁止用户采用password登录
RUN sed -i 's/UsePAM yes/UsePAM no/g' /etc/ssh/sshd_config
RUN yum install -y openssh-clients
#添加相应的镜像系统下的root用户，这个是必须的操作
RUN echo "root:root" | chpasswd
RUN echo "root ALL=(ALL)    ALL" >> /etc/sudoers

EXPOSE 22

CMD [ "/usr/sbin/sshd","-D"]

#运行生成镜像 docker build -t hadoop:1.0 .

#生成容器并进入 docker run -itd --name hadoopdatenode hadoop:1.0

#进入容器docker exec -i -t 550b07ac2a35 /bin/sh

#exit退出容器