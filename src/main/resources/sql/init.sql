#创建数据库，用户并进行关联
CREATE DATABASE orders DEFAULT CHARACTER SET utf8;
CREATE USER 'hzl'@'%' IDENTIFIED BY '123456';
CREATE USER 'hzl'@'localhost' IDENTIFIED BY '123456';
grant ALL PRIVILEGES on orders.* to hzl@'%';
GRANT ALL PRIVILEGES ON orders.* TO hzl@'localhost';
flush privileges;


#主从命令
主数据执行命令
1：创建用户同步数据的账号
CREATE USER 'slave'@'%' IDENTIFIED BY '123456';
CREATE USER 'slave'@'localhost' IDENTIFIED BY '123456';
-- grant ALL PRIVILEGES on orders.* to slave@'%';
-- GRANT ALL PRIVILEGES ON orders.* TO slave@'localhost';
-- 分配权限
GRANT REPLICATION SLAVE ON *.* TO 'slave'@'localhost';
flush privileges;
SHOW MASTER STATUS


#从数据库执行
reset slave;
CHANGE MASTER TO MASTER_HOST = 'localhost',
MASTER_PORT=3307,
MASTER_USER = 'slave',
MASTER_PASSWORD = '123456',
MASTER_LOG_FILE = 'mysql-bin.000005',
MASTER_LOG_POS = 73;

-- 开启主从复制
start slave;
-- 关闭主从复制
stop slave;

show slave status;