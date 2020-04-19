#文档
    https://github.com/alibaba/spring-cloud-alibaba/wiki/RocketMQ
#在启动类添加如下注解
    @EnableBinding({ Source.class, Sink.class })
    
#官方文档 
    https://rocketmq.apache.org/docs/transaction-example/

#上传服务器
   
    scp -r rocketmq-all-4.7.0-bin-release.zip root@ip:/root
   
#解压
   
    unzip rocketmq-all-4.7.0-bin-release.zip
    
#修改内存配置
    
    1:启动脚本可以配置MQ整体内存大小，有两个启动脚本，runbroker.sh 和runserver.sh。
    脚本里面的默认配置信息是
    
    JAVA_OPT="${JAVA_OPT} -server -Xms4g -Xmx4g -Xmn2g -XX:PermSize=128m -XX:MaxPermSize=320m"
    
    以上配置可以根据自己情况进行调整，记得runbroker.sh 和runserver.sh都要修改。
    
    2:mqbroker和mqnamesrv的内存调整
    这两项配置也很重要，默认是500m到1g。具体文件配置是mqbroker.xml和mqnamesrv.xml。
    文件里面的配置信息是
    
    <options>
             <-Xms200m></-Xms200m>
             <-Xmx200m></-Xmx200m>
             <-XX:NewSize>50M</-XX:NewSize>
             <-XX:MaxNewSize>50M</-XX:MaxNewSize>
             <-XX:PermSize>30M</-XX:PermSize>
             <-XX:MaxPermSize>30M</-XX:MaxPermSize>
     </options>
  
    以上可以根据自己情况进行配置。
    
    3:要注意的事情是mqbroker.xml和mqnamesrv.xml的内存不要超过runbroker.sh 和runserver.sh的内存，不然会引起内存不够导致奔溃。
    
    
   
#启动 Startup Name Server 注册中心,其中&的作用是生成子进程后端运行
    sh bin/mqnamesrv &
    
#启动 Startup Broker
    
    sh bin/mqbroker -n localhost:9876 &
    
#手动创建topic

    sh bin/mqadmin updateTopic -n localhost:9876 -c DefaultCluster -t test-topic
    
# 配置
    
    spring:
      cloud:
        stream:
          #消息中间键
          #rocketmq
          rocketmq:
            binder:
              name-server: 10.200.254.54:9876
            bindings:
              input1:
                consumer:
                  orderly: true #Consumer 是否同步消费消息模式。
              output1:
                producer:
                  group: binder-group
                  sync: true
          bindings:
            input1:
              destination: test-topic
              content-type: text/plain
              group: test-group1
            output1:
              destination: test-topic
              content-type: application/json