**redis分布式锁，基于redission实现 https://github.com/redisson/redisson**  
   
    参考：
    redis docker镜像：https://hub.docker.com/_/redis
    下载地址：https://redis.io/download
   
    注意事项
    能不用锁就不用
    redisson实现分布式锁操作，避免死锁，也就是不释放锁
    分布式锁锁的是代理的方法，aop代理后在运行方法前加锁，方法运行结束后解锁
    
    指定配置文件启动redis：
    ./redis-server /usr/local/redis/redis.conf
    
    进入redis命令中端
    redis-cli
    
    连接到指定服务和端口（默认localhost，和6379端口）
    redis-cli -h ip地址 -p d端口后
    关闭redis:
    shutdown
    
    清楚缓存:
    flushall
    
    主从：
    从执行如下明令：
    SLAVEOF host port（更换同步的主服务器，原本就没有关联主服务器的话相当于陪住主节点，该命令适合redis运行中使用）
    
    SLAVEOF NO ONE （对一个从属服务器执行该命令 将使得这个从属服务器关闭复制功能，并从从属服务器转变回主服务器，
    原来同步所得的数据集不会被丢弃）
    
    