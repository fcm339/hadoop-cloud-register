#docker启动oracle
1:https://blog.csdn.net/m0_37256801/article/details/104015731

docker run -d --name myoracle -p 9080:8080 -p 1521:1521 truevoly/oracle-12c:latest

docker exec -it 5bf78fe3e0b6 /bin/bash

create user hzl identified by hzl;
create tablespace hzl datafile '/u01/app/oracle/oradata/hzl.dbf' size 600m;
alter user hzl default tablespace hzl;
grant dba,resource,unlimited tablespace to hzl;

2:
创建存储过程:
    
    1：无参存储过程：
        
        create or replace procedure test
        as或者is
        name varchar(10);--声明变量，注意varchar需要指定长度
        age NUMBER;
        begin
          name:='xiaoming';--变量赋值
          age:=18;
          dbms_output.put_line('name='||name||', age='||age);--通过||符号达到连接字符串的功能
        end;
    
    
    2：有参数存储过程：
        
        CREATE OR REPLACE PROCEDURE 存储过程名称(param1 student.id%TYPE)
        AS/IS
        name student.name%TYPE;
        age number :=20;
        BEGIN
          --业务处理.....
        END;
        
    
    
调用存储过程：
    
    
oracle存储过程中is和as区别

    在存储过程(PROCEDURE)和函数(FUNCTION)中没有区别；
    在视图(VIEW)中只能用AS不能用IS；
    在游标(CURSOR)中只能用IS不能用AS