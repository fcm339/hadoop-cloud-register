#!/bin/sh
#只保留1天内的日志索引
LAST_DATA=`date -d "-1 days" "+%Y.%m.%d"`
#删除上个月份所有的索引
curl -XDELETE 'http://localhost:9200/*-'${LAST_DATA}'*'

#每天的凌晨一点清除索引
#0 1 * * *  ./es-index-clear.sh