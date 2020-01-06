#计划安排，集成spring cloud aliababa ，hadoop，前端vue

集成mvc，WebMvcConfigurationSupport


集成mybatis，druid数据库连接池(是否可以动态修改连接数)，多数据源(读写分离,主从数据库同步的延迟),
    分页
    mybatis:完成
    druid:完成
    mybatis工具包：
    多数据源：
    读写分离：
    执行sql脚本：

集成springsecurity

集成定时器，队列只消费一次

集成分布式事务和分布式锁，缓存：
    参考：https://github.com/Nepxion/Aquarius 
    集成redis:
    集成：zookeeper
    
集成条形码，模版引擎组件 https://github.com/Nepxion/Zxing(完成)

集成kafka，rocketmq

集成dubbo，rpc

开发权限，aop

集成 email（待开发完善）

日志配置logback实现了slf4j，指定日志目录，分片，日志查询脚本grep.sh

文件功能file服务，开发上传文件接口，开发http请求下载文件的功能(完成，HttpFileDownloadTest)

增加word分析组件，关键字搜索（有些文件中不允许出现一些关键字）hadoop文件分析


开发启动脚本start.sh idea配置(-Xms0m -Xmx512m -Dspring.profiles.active=local)