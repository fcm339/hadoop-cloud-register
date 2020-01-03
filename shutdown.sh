#!/bin/sh
#lsof -i:8888
target_dir=`pwd`

pid=`ps ax | grep -i 'hadoop' | grep ${target_dir} | grep java | grep -v grep | awk '{print $1}'`
if [ -z "$pid" ] ; then
        echo "没有服务在运行----------"
        exit -1;
fi

echo "服务运行中..."

kill ${pid}

echo "成功关闭服务"