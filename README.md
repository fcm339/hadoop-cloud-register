#计划安排，集成spring cloud aliababa ，hadoop，前端vue

集成mvc，WebMvcConfigurationSupport


集成mybatis，druid数据库连接池(是否可以动态修改连接数)，多数据源(读写分离,主从数据库同步的延迟),

    分页:https://github.com/pagehelper/Mybatis-PageHelper(完成)
    集成jpa（完成，集成了mybatis工具包后基本不会用）
    mybatis:完成
    druid:完成
    mybatis工具包：https://github.com/abel533/Mapper（完成）
    多数据源：完成 数据源注解@DataSource必须在mapper注入前执行，事务回滚待测试
    读写分离：参考：https://www.cnblogs.com/cjsblog/p/9712457.html，https://mp.weixin.qq.com/s/uivql_NMhWSnjknL9o5M3A（完成）
    执行sql脚本：groovy或者后期根据mybatis开发一个，或者不开发
    mybatis一级（默认开启，和sqlsession的生命周期一致），二级缓存设置
    
    
集成springsecurity

集成定时器，队列只消费一次

集成分布式事务和分布式锁，缓存：(数据库相关完成后需要开始了)
    参考：https://github.com/Nepxion/Aquarius 
    集成  redis:
    集成：zookeeper
    
集成条形码，模版引擎组件 https://github.com/Nepxion/Zxing(完成)

集成kafka，rocketmq

集成dubbo，rpc

开发权限，aop

集成 email（完成，后期集成数据库）

日志配置logback实现了slf4j，指定日志目录，分片，日志查询脚本grep.sh（完成)

文件功能file服务，开发上传文件接口，开发http请求下载文件的功能(完成，HttpFileDownloadTest)

增加word分析组件，关键字搜索（有些文件中不允许出现一些关键字）hadoop文件分析


开发启动脚本start.sh idea配置(-Xms0m -Xmx512m -Dspring.profiles.active=local)

集成gitlib ci/cd,自动构建docker镜像


----大数据相关
1：集成 Elasticsearch（docker安装）
