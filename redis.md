**redis分布式锁，基于redission实现 https://github.com/redisson/redisson**  
   
    注意事项
    能不用锁就不用
    redisson实现分布式锁操作，避免死锁，也就是不释放锁
    分布式锁锁的是代理的方法，aop代理后在运行方法前加锁，方法运行结束后解锁
    
    