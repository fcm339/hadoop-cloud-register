#!/usr/bin/env bash
#日志查询脚本
basedir=$1
search=$2
echo "目录${basedir}"
cd ${basedir}
for log in $(ls)
do
   echo "开始搜索${log}"
   grep "${search}" ${log}
   echo "${log}搜索结束"
done