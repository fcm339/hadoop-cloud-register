#!/bin/sh
target_dir=`pwd`
jar_name='register'
branch_name='local'


pid=`ps ax | grep -i $jar_name | grep $target_dir | grep java | grep -v grep | awk '{print $1}'`
if [ -z "$pid" ] ; then
        echo "没有服务在运行----------"
else
    echo "服务运行中..."
    kill ${pid}
fi
echo "开始git pull..."
git pull origin master
mvn clean package -U -DskipTests=true
cd target
mv hadoop.jar ${jar_name}.jar

nohup java -jar \
-Xms512m -Xmx1024m \
-Dspring.profiles.active=${branch_name} \
./${jar_name}.jar > ../logs/${jar_name}.log & \
tail -f ../logs/$jar_name.log