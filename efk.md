#后期将这三个镜像上传到个人阿里云镜像仓库

kibana: localhost:5601

elastisearch:localhost:9200

docker-compose down

docker-compose up -d

docker logs 容器id

#进去容器
docker exec -i -t aae09734dd56 /bin/sh

#生成fluent镜像
docker build --pull -t fluent:local .

修改日志输出格式来和match匹配


#定时删除elastisearch文件
    每天的凌晨一点清除索引
    0 1 * * *  ./es-index-clear.sh
    
    
#导出镜像
docker save elasticsearch:7.6.0>elasticsearch.tar
scp -r elasticsearch.tar CFSAdmin@10.246.194.37:/home/CFSAdmin
docker load <elasticsearch.tar


docker save docker.elastic.co/beats/filebeat:7.6.0>filebeat.tar
scp -r filebeat.tar root@localhost:/root/efk
docker load <filebeat.tar


docker save kibana:7.6.0>kibana.tar
scp -r kibana.tar CFSAdmin@10.246.194.69:/home/CFSAdmin
docker load <kibana.tar

docker save logstash:7.6.0>logstash.tar
scp -r logstash.tar root@localhost:/root/efk
docker load <logstash.tar

#启动docker-compose
docker-compose up -d
#关闭docker-compose
docker-compose down


#访问kibana
http://localhost:5601

#查看容器运行日志
docker logs -f 容器id

#运行镜像并进入容器
docker run -i -t logstash:7.6.0 --name logstash

#下载filebeat
docker pull docker.elastic.co/beats/filebeat:7.6.0

#访问elasticsearch-head
http://localhost:9100/?base_uri=http://localhost:9200&auth_user=1&auth_password=1

#注意如果启动失败，基本都是对应的映射文件权限不足