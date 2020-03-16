#hdfs分布式文件系统

        将一个文件拆分存储到多个块上
        
        通过文件块备份提高容错能力
#hdfs中的名词
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
    
    
#使用centos制作Hadoop镜像,只是为了本地开发方便才做的镜像，正式环境不需要

    直接看Dockerfile文件

#配置：

    配置文件目录：/usr/local/hadoop/etc/hadoop
    
    第一次启动需要格式化：hadoop namenode -format
    hdfs启动脚本目录：/usr/local/hadoop/sbin/start-dfs.sh
    hdfs停止脚本目录：/usr/local/hadoop/sbin/stop-dfs.sh(不要用sh 启动直接./)
    
    jps查看启动
    
 #hadoop集群写到有道文档
 
 #伪分布式安装配置（用的hadoop3.2.1）
 
    #需要修改的配置，启动容器前在
        文件：hadoop-env.sh
        添加:export JAVA_HOME=/usr/lib/jvm/java-1.8.0
        export HADOOP_HOME=/usr/local/hadoop
        
        文件stop-yarn.sh start-yarn.sh,在头部添加如下配置
        YARN_RESOURCEMANAGER_USER=root
        HADOOP_SECURE_DN_USER=yarn
        YARN_NODEMANAGER_USER=root
        
        
        文件:start-dfs.sh,stop-dfs.sh，在头部添加如下配置
        HDFS_DATANODE_USER=root
        HADOOP_SECURE_DN_USER=hdfs
        HDFS_NAMENODE_USER=root
        HDFS_SECONDARYNAMENODE_USER=root
        
        修改的配置文件：
        core-site.xml
        hdfs-site.xml
        mapred-site.xml
        yarn-site.xml
        
        
     #容器启动后需要手动执行的命令
        docker exec -it bc664c09ca3a /bin/bash 进入容器
        #ssh-copy-id -i ~/.ssh/id_rsa.pub 127.0.0.1 ，将公钥发送给localhost，个集群机器要相互发送，可以写在docker-compose里面 (通过ssh ip进行测试是否成功)
        hadoop namenode -format  第一次启动需要格式化：
        /usr/local/hadoop/sbin/start-dfs.sh  启动hdfs
        /usr/local/hadoop/sbin/start-yarn.sh 启动yarn
        jps 查看启动的java应用
     #命令
        查看集群状态
        hadoop dfsadmin -report       
        
     #启动成功后输入地址
         访问HDFS的管理界面：ip:9870
         
         访问YARN的管理界面：http://ip:8088/cluster
# hdfs命令
    
    列出文件系统中各个文件由那些块组成
    hadoop fsck / -files -blocks
    
    创建目录
    hadoop fs -mkdir /test
    
    显示目录信息
    hadoop fs -ls hdfs://localhost:9000/
    
    将本地文件复制到hdfs(hdfs://localhost:9000/前缀可以省略)
    hadoop fs -copyFromLocal test.txt /data/test/
    
    等同于copyToLocal，就是从hdfs下载文件到本地
    hadoop fs -get hdfs://localhost:9000/skip.txt
    
    将文件从hdfs复制到本地(hdfs://localhost:9000/前缀可以省略)
    hadoop fs -copyToLocal /data/test/test.txt ./ss.txt
         
         
    等同于copyFromLocal
    hadoop fs -put test.txt /data/test/
         
    将本地文件剪切后复制到hdfs
    hadoop fs -moveFromLocal sss.txt /data
    
    将文件从hdfs剪切后复制到本地(该功能还为实现)
    hadoop fs -moveToLocal /data/sss.txt cutcopy.txt
    
    从hdfs的一个路径拷贝hdfs的另一个路径
    hadoop fs -cp /data/test/test.txt /data/ship.txt
    
    在hdfs目录中移动文件
    hadoop fs -mv /data/ship.txt /
    
    追加一个文件到已经存在文件的末尾
    hadoop fs -appendToFile ./ss.txt /data/test/test.txt
    
    显示文件内容
    hadoop fs -cat /data/test/test.txt
    
    显示文件的末尾
    hadoop fs -tail /data/test/test.txt
    
    以字符串形式打印一个文件的内容
    hadoop fs -text /data/test/test.txt
    
    合并下载的多个文件
    hadoop fs -getmerge hdfs://localhost:9000/ship.txt hdfs://localhost:9000/data/test/test.txt ./sum.txt
    
    
    删除文件或文件夹
    hadoop fs -rm -r /data
   
    删除空目录,不为空是不会删除的
    hadoop fs -rmdir /test
    
    统计文件系统的可用空间信息
    hadoop fs -df -h /
    
    统计文件夹的大小信息
    hadoop fs -du -s -h /test
    
    统计一个指定目录下的文件节点数量
    hadoop fs -count /
    
    设置hdfs中文件的副本数量
    hadoop fs -setrep 3 /skip.txt
    
    文件权限和linux一样
    
    -chgrp 修改用户组
    -chmod 修改用户权限
    -chown 修改用户所有者
    hadoop fs -chmod a+x /ship.txt
    hadoop fs -chown someuser:somegrp /hello.txt
    
 #开发hdfs的java客户端连接
  
    配置文件信息：
    hadoop.hdfs.name-node 为hadoop的namenode节点的ip地址
    