#!/usr/bin/env bash

#安装iftop
yum install iftop -y

#查看带宽eth0表示网卡
iftop -i eth0 -n  -P

10.244.11.27

10.244.38.163

10.244.7.41

scp -r jstack root@10.64.1.214:/root

scp -r jstack root@10.64.1.214:/root

curl 'http://10.244.11.55:8080/oauth/static/main/css/login.css'   -H 'Connection: keep-alive'   -H 'Pragma: no-cache'   -H 'Cache-Control: no-cache'   -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36'   -H 'Accept: text/css,*/*;q=0.1'   -H 'Referer: http://alm.qdgxjt.com:8080/oauth/login'

curl 'http://10.244.38.177:8080/oauth/static/main/css/login.css'   -H 'Connection: keep-alive'   -H 'Pragma: no-cache'   -H 'Cache-Control: no-cache'   -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36'   -H 'Accept: text/css,*/*;q=0.1'   -H 'Referer: http://alm.qdgxjt.com:8080/oauth/login'

curl 'http://10.244.7.59:8080/oauth/static/main/css/login.css'   -H 'Connection: keep-alive'   -H 'Pragma: no-cache'   -H 'Cache-Control: no-cache'   -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36'   -H 'Accept: text/css,*/*;q=0.1'   -H 'Referer: http://alm.qdgxjt.com:8080/oauth/login'

排查阻塞的锁
jstack pid｜grep -C 10 BLOCKED

top查看cpu，内存情况

top -Hp pid可以查看进程下的线程情况，包括cpu，内存，存活时间

java线程卡死：

    https://blog.csdn.net/soldier_jw/article/details/113629683?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control
    https://www.cnblogs.com/silentdoer/p/11736498.html

#查看线程状态，的线程数
jstack -l 1|grep java.lang.Thread.State  | awk '{print $2$3$4$5}' | sort | uniq -c

#连接远程


#10进制转换16
https://tool.oschina.net/hexconvert


jstat查看虚拟机堆内存情况，垃圾回收情况:
    jstat -gc pid

    https://www.jianshu.com/p/123079b47670

