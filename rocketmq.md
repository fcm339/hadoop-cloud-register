#在启动类添加如下注解
    @EnableBinding({ Source.class, Sink.class })
    
#官方文档 
    https://rocketmq.apache.org/docs/transaction-example/

#上传服务器
   
    scp -r rocketmq-all-4.7.0-bin-release.zip root@ip:/root
   
#解压
   
    unzip rocketmq-all-4.7.0-bin-release.zip
   
#启动 Startup Name Server 注册中心,其中&的作用是后端运行
    sh bin/mqnamesrv &
    
#启动 Startup Broker
    
    sh bin/mqbroker -n localhost:9876 &
    