# spring
    参考：https://www.cnblogs.com/zhangshitong/p/9166727.html
    https://blog.csdn.net/fei1234456/article/details/106609226/
    spring默认是单例模式
    controller中不要定义成员变量，会有线程安全问题，非要用要么定义为@Scope("prototype")活着用threadlocal
    
    @Scope("singleton")设置单例模式
     @Scope("prototype")设置原型模式模式（每次请求都生成新的线程）