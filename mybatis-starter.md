#引入多数据源插件
 <!--集成自定义多数据源插件-->
    <dependency>
        <groupId>com.hzl.cloud</groupId>
        <artifactId>mybatis-starter</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
        
    该插件默认，只支持两个数据源，如果需要多个需要手动修改该插件
    
    该插件依赖druid数据库连接池，mybaits的tk插件，mybatis
    
  需要添加的配置：
   
    hadoop:
      openMulti: true #是否开启多数据源，true为是，false为否，单数据源的情况下默认启动master数据库配置
      
    mybatis配置：
    # 包扫描或者在启动类上添加@MapperScan或者在每个mapper接口上添加@Mapper注解
    mybatis:
      mapperLocations: classpath*:/mapper/*.xml
      configuration: # 数据库下划线转驼峰配置
        mapUnderscoreToCamelCase: true
        cache-enabled: false #关闭二级缓存
      
    指定数据源注解：不配置的情况默认为主数据源
    @DataSource(name = "salve1")
    
    
   注意事项：
   
    数据源注解@DataSource必须在mapper注入前执行
    