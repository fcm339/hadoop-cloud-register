#计划安排，集成spring cloud aliababa ，hadoop，前端vue
集成 email（完成，后期集成数据库）

日志配置logback实现了slf4j，指定日志目录，分片，日志查询脚本grep.sh（完成)

集成mvc，WebMvcConfigurationSupport


集成mybatis，druid数据库连接池(是否可以动态修改连接数)，多数据源(读写分离,主从数据库同步的延迟),

    分页:https://github.com/pagehelper/Mybatis-PageHelper(完成)
    集成jpa（完成，集成了mybatis工具包后基本不会用）
    mybatis:完成（封装了jpa）
    druid:完成
    mybatis工具包：https://github.com/abel533/Mapper（完成）
    多数据源：完成 数据源注解@DataSource必须在mapper注入前执行，事务回滚待测试
    读写分离：参考：https://www.cnblogs.com/cjsblog/p/9712457.html，https://mp.weixin.qq.com/s/uivql_NMhWSnjknL9o5M3A（完成）
    执行sql脚本：groovy或者后期根据mybatis开发一个，或者不开发
    mybatis一级（默认开启，和sqlsession的生命周期一致），二级缓存设置
    
开发权限，aop用于自定义注解功能实现，方法代理(学习资料：https://github.com/Nepxion/Matrix)
   注解执行时机：启动，调用，结束（bean的生命周期）
    针对spring的生命周期，开发对应的实现类例子，供后期复制调用
    
    
开发多线程工具类：


集成springsecurity

集成定时器，队列只消费一次

集成分布式事务和分布式锁，缓存：(数据库相关完成后需要开始了)
    参考：https://github.com/Nepxion/Aquarius 
    集成  redis:
    集成：zookeeper
    
集成条形码，模版引擎组件 https://github.com/Nepxion/Zxing(完成)

集成kafka，rocketmq

集成dubbo，rpc,netty(nio)




文件功能file服务，开发上传文件接口，开发http请求下载文件的功能(完成，HttpFileDownloadTest)

增加word分析组件，关键字搜索（有些文件中不允许出现一些关键字）hadoop文件分析

开发启动脚本start.sh idea配置(-Xms0m -Xmx512m -Dspring.profiles.active=local)

集成gitlib ci/cd,自动构建docker镜像


----大数据相关
1：集成 Elasticsearch（docker安装）

2：基于大数据分析开发问答式客服系统（随着时间推移数据量的增大，系统回答更加趋于智能）
    2.1:自然语言处理问题解析，分析语言后在数据库中搜索关键字
    2.2 热点问题记录，人工回答问题后记录数据库，当下次提问时自动回答
    2.3 初始化问题和答案，导入长见问题及答案。excel导入（推荐）工具类已经实现
    
3：主动推荐式客服系统（电商，京东淘宝已经很成熟了，其他产业对该场景需求不大，数据分析对有大量数据积累的公司是比较适合的，保险，金融，能源等）
    电商需要时时推荐，其他的只需要历史分析
   分析客户习惯，客户点击app或者网页，把响应的图片文字对应的信息发送到后台记录分析，时时推送
   统计大多数客户的需求调整推荐商品结构，调整库存