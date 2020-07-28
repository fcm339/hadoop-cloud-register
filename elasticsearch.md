<!--集成elasticsearch,进行文件索引-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
        </dependency>
        
       spring.data.elasticsearch.cluster-nodes=127.0.0.1:9300

#验证是否安装成功
    http://localhost:9200/
    
#基本概念
    Index, Index 是文档（ Document ）的集合 ， Index 下面包含了 Type ， 用 于对 Document 进一步分类。 可 以理解为 ES 中的 Index 相 当于数据库 ， 而 Type 相 当于数据库中 的表 ， ES 中可以轻易地联 合 Index 和 Type 来搜索数据， 数据库却不能。 
    Type， 用来进一步组织 Document， 一个 Index 下可以有多个 Type， 比如用户信息是 一 个 Type， 用户的支付记录 是一个 Type。 
    Document， 文档是 ES 能够存储和搜索 的基本信息， 类似数据库表行 数据， Document 为 JSON 格式， 文档属于 Type 。
    Node （节点〉 ， 节点是集群里的 一 台 ES Server， 用 于文档的存储和 查询 。 应用可以只 有一个节点， 也可以由上百个 节点组成集群来 存储和搜索数据 。 每个节点都有一 个节 点名字 ， 以及所属集群的 名字。 
    集群 ， 同样集群名 的节点将组合为 ES 集群 ， 用来联合完成数 据 的存储和搜索。 默认 的集群名字是 elasticsearch 。 分区（ Shards ）和复制（ Replicas ），
    每个 Index 理论上都可以包 含大量的数据， 超过 了单个节点的存 储限制， 而且， 单个节点处理那 么大的数据， 将明显限制存储 和搜索 性能 。 为了解决这个问 题， ES 会进一步将 Index 在物理上细分为 多个分区 ， 
    而且这些 分区会按照配置 复制到多个节点 ， Index 的分区称为主分 区， 复制的分区称为 复制分区 。 这样的好处是既 保证数据不会丢 失， 又提高了查询的 性能 。

