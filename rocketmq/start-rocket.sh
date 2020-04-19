#!/bin/sh
export JAVA_HOME=/Library/java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home

nameserv=`jps|grep NamesrvStartup | awk '{print $1}'`

broker=`jps|grep BrokerStartup | awk '{print $1}'`

if [ -z "$nameserv" ] ; then
        echo "nameserv没有运行----------"
else
        echo "准备kill nameserv"
        kill $nameserv
fi

if [ -z "$broker" ] ; then
        echo "broker没有运行----------"
else
        echo "准备kill broker"
        kill $broker
fi



sh /Users/hzl/Desktop/hadoop/rocketmq-all-4.7.0-bin-release/bin/mqnamesrv & #有点小问题,后面的命令会执行失败


sh /Users/hzl/Desktop/hadoop/rocketmq-all-4.7.0-bin-release/bin/mqbroker -n localhost:9876 &




