-- hadoop 用户创建
CREATE USER 'hadoop'@'%' IDENTIFIED BY 'hadoop';
CREATE USER 'hadoop'@'localhost' IDENTIFIED BY 'hadoop';
flush privileges;

-- 基础数据库创建

-- hadoop数据库
CREATE DATABASE hadoop DEFAULT CHARACTER SET utf8mb4;
GRANT ALL PRIVILEGES ON hadoop.* TO hadoop@'%';
GRANT ALL PRIVILEGES ON hadoop.* TO hadoop@'localhost';
FLUSH PRIVILEGES;




