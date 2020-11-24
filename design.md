# 代理模式
    #参考：https://www.cnblogs.com/qlqwjy/p/7550609.html
    
    #1动态代理工厂类：
    com.hzl.hadoop.design.proxy.ProxyFactory
    
    动态代理测试类：
    ProxyTest
    
    
    #静态代理
    被代理对象与代理对象一起实现相同的接口或者是继承相同父类，
    
    
    #动态代理和静态代理的区别：
       动态代理，代理类不需要实现和被代理类一样的接口的父类，静态代理需要
   
    #Spring中强制使用Cglib代理
        
        参考：mybatis-starter中的com.hzl.cloud.config.mybatis.DataSourceAspect