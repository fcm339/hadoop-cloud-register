#hdfs分布式文件系统

        将一个文件拆分存储到多个块上
        
        通过文件块备份提高容错能力
#hdfs中的名次
    NameNode：即Master，（namenode命名空间镜像文件和编辑日志文件的形式存储映射信息，文件信息，副本策略信息等）
    1、管理 HDFS 的命名空间。
    2、管理数据块（Block）映射信息
    3、配置副本策略
    4、处理客户端读写请求。
    
    存储策略：
    A、内存中有一份完整的元数据(内存meta data)
    B、磁盘有一个“准完整”的元数据镜像（fsimage）文件(在namenode的工作目录中)
    C、用于衔接内存metadata和持久化元数据镜像fsimage之间的操作日志（edits文件）注：当客户端对hdfs中的文件进行新增或者修改操作，操作记录首先被记入edits日志文件中，当客户端操作成功后，相应的元数据会更新到内存meta.data中
    
    补充:
    1、fsimage文件是线性结构，都是0和1，很难查找或者修改某条数据，所以才会定期checkpoint。
    2、edits（编辑日志文件）记录的是操作步骤，类似于mysql的binlog
    3、fsimage（命名空间镜像文）记录的是这个文件备份了几份，分别叫什么名称

    
    DataNode：就是Slave。NameNode 下达命令，DataNode 执行实际的操作。
    1、存储实际的数据块。
    2、执行数据块的读/写操作。
    
    Secondary NameNode：并非 NameNode 的热备。当NameNode 挂掉的时候，它并不能马上替换 NameNode 并提供服务。
    1、辅助 NameNode，分担其工作量。
    2、定期合并 fsimage和fsedits，并推送给NameNode。
    3、在紧急情况下，可辅助恢复 NameNode。
         
        
    #namenode高可用
     1：将元数据时时同步到远程的网络文件系统（NFS）
     2：运行Secondary NameNode
     3：假设namenode挂了，一般是把nfs的文件内容复制到Secondary NameNode，并将Secondary NameNode作为namenode
#hdfs的shell命令
    列出文件系统中各个文件由那些块组成
    hadoop fsck / -files -blocks
    
#使用centos制作Hadoop镜像