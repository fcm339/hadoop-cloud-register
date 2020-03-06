#计划安排，集成spring cloud aliababa ，hadoop，前端vue
集成 email（完成，后期集成数据库）

日志配置logback实现了slf4j，指定日志目录，分片，日志查询脚本grep.sh（完成)

集成mvc完成，WebMvcConfigurationSupport完成，json处理完成，日期格式处理完成

集成webflux 待开发


集成mybatis，druid数据库连接池(是否可以动态修改连接数)，多数据源(读写分离,主从数据库同步的延迟),

    分页:https://github.com/pagehelper/Mybatis-PageHelper(完成)
    集成jpa（完成，集成了mybatis工具包后基本不会用）
    tk:完成
    mybatis:完成
    druid:完成
    mybatis工具包：https://github.com/abel533/Mapper（完成(封装了jpa）
    多数据源：完成 数据源注解@DataSource必须在mapper注入前执行，事务回滚待测试完成
    读写分离：参考：https://www.cnblogs.com/cjsblog/p/9712457.html，https://mp.weixin.qq.com/s/uivql_NMhWSnjknL9o5M3A（完成）
        通过hadoop.openMulti配置来开启和关闭多数据，如果不配置默认开启单数据源
    执行sql脚本：groovy或者后期根据mybatis开发一个，或者不开发
    mybatis一级（默认开启，和sqlsession的生命周期一致）关闭，二级缓存设置(不用)
        缓存：热点数据存放缓存，不经常修改的数据，用户权限，字典数据，配置信息
    mysql:集群和主从，分库分表（待整理文档，做成docker镜像）
    执行存储过程实例（待开发)，
    批处理sql开发包括插入和更新(待开发)
    mybaits拦截器开发（待开发）
    mybatis存储日期类型自动将时间缩短，更新2019-09-01会变成2019-08-31（已经修复）\
    String类型转换成Date时区显示有问题（bug）方法：localStringToDate
        
集成条形码，模版引擎组件 https://github.com/Nepxion/Zxing(完成)

多语言功能开发
    
开发权限，aop用于自定义注解功能实现，方法代理(学习资料：https://github.com/Nepxion/Matrix)(待深入学习和完善)

    注解执行时机：启动，调用，结束（bean的生命周期）
    针对spring的生命周期，开发对应的实现类例子，供后期复制调用（完成）
    
    
集成easyexcel,文件位置com.hzl.hadoop.file.excel.ExcelDone，demo待完善


增加io流操作工具类(后期实际运用中完善)

集成分布式事务和分布式锁，缓存：(数据库相关完成后需要开始了)
    
    参考： 
    集成  redis: 
            redistemplate工具类（写了今本的，其他的开发中待完善）
            jackson配置完成，fastjson配置待阿里bug修复后期，gson配置不要了
            cache注解实例（待完成），
            redistemplate测试类（待完成），
            redis分布式锁（开发中）
                集成Redisson实现分布式操作（https://github.com/redisson/redisson）
                https://gitee.com/ztp/redisson-spring-boot-starter(选用这个jar)
                第一步：读取配置文件生成Config对象
            整理redis主从和集群文档
    集成kafka，rocketmq
    集成：zookeeper
    集成 spring cache
    集成 缓存监控
    
    分布式锁的使用场景，判断数据是否被多个用户共享。
    
集成支付功能 （https://github.com/Javen205/IJPay，https://gitee.com/javen205/IJPay，https://github.com/easy-pay/spring-boot-easy-pay）
    
    在支付的和FreeMarkerZxingController条形码基础上开发报销单业务逻辑，结合消息中间件，异步处理报销单不是直接插入数据库
    用户提交报销单后直接发送到消息中间件并提示用户提交成功，后续处理由消息中间件分发给服务异步处理，减少并发和对数据库造车的压力
    https://www.cnblogs.com/lizm166/p/11023373.html
    
开发多线程工具类：线程池

开发工作流

集成定时器，队列只消费一次


集成springsecurity,开启https用nginx，开发一套完善的权限控制组件(使用简单，性能优越)

集成dubbo，rpc,netty(nio)

限制访问流量服务器和应用都需要


文件功能file服务，开发上传文件接口，开发http请求下载文件的功能(完成，HttpFileDownloadTest)
     
     添加文件压缩解压操作，大文件网络传输有问题

开发启动脚本start.sh idea配置(-Xms0m -Xmx512m -Dspring.profiles.active=local)

集成gitlib ci/cd,自动构建docker镜像，k8部署，参考资料：https://gitee.com/itmuch/docker-book（已经下载到本地）


----大数据相关（后期开发一个客服系统，先将基础框架搭建完善，悲伤的百度搜索引擎）

1：集成 Elasticsearch（docker安装）

     中文分词软件：https://github.com/ysc/word（分析文本关键字，问答系统中文分析）
     
    
2： 基于大数据分析开发问答式客服系统（随着时间推移数据量的增大，系统回答更加趋于智能）
    
   
    2.1:自然语言处理问题解析，分析语言后在数据库中搜索关键字
    2.2 热点问题记录，人工回答问题后记录数据库，当下次提问时自动回答
    2.3 初始化问题和答案，导入长见问题及答案。excel导入（推荐）工具类已经实现
    
3：主动推荐式客服系统（电商，京东淘宝已经很成熟了，其他产业对该场景需求不大，数据分析对有大量数据积累的公司是比较适合的，保险，金融，能源等）

    电商需要时时推荐，其他的只需要历史分析
    分析客户习惯，客户点击app或者网页，把响应的图片文字对应的信息发送到后台记录分析，时时推送
    统计大多数客户的需求调整推荐商品结构，调整库存
   
--集成物联网，收集硬件数据和远程操控
   
   
## java爬虫开发
Java爬虫工程师（SH）(深圳平安综合金融服务有限公司)

25000以上元/月

岗位描述 1. 参与分布式爬虫和数据采集系统的架构设计和开发； 
2. 解决规模增长带来的技术和业务问题，确保提供高可靠数据服务，保证系统稳定、高效运行； 
3. 设计爬虫策略和防屏蔽规则，提升网页抓取的效率和质量； 
4. 负责大规模文本、图像、视频数据的抓取、抽取，去重、分类，垃圾过滤，质量识别等工作； 
5. 研究各种目标网站的形态，互联网特征挖掘，发现它们的特点和规律。 岗位要求 
1. 基本功扎实，熟练使用常用数据结构和相关算法，精通 java io、多线程、集合等；本科及以上学历，5年及以上相关经验；
2. 熟悉缓存、消息机制、并发框架异步框架等；
3. 熟悉Internet基本协议（如TCPIP. HTTP等）； 
4. 熟悉HTML,DOM,XPATH,CSS，对DOM有一定的功底能够熟练使用Jsoup等进行分析网页，对模拟登录，模拟浏览器、APP抓取经验优先；
5. 有Nutch、Heritrix、Scrapy、Hadoop等系统经验，二次开发者优先； 
6. 有基于网页结构的自动识别抽取算法，结构化结果的经验者优先； 
7. 对有可视化采集，基于JS的自动规则生成，分布式采集的经验者优先；
8. 有从事舆情社交数据及热点采集分析等的工作经验者优先；
9. 良好的团队合作意识，对技术饱有热情。

----前端最后做
以ant design pro为基础开发
    文档：https://www.yuque.com/ant-design/course
    项目：https://pro.ant.design/index-cn