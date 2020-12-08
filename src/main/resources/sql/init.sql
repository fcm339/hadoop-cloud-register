CREATE DATABASE orders DEFAULT CHARACTER SET utf8;
grant all privileges on orders.* to hzl@’%’ identified by ‘123456’;
flush privileges;