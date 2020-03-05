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
密码：3kdf$Fhn9s
docker save elasticsearch:6.8.2>elasticsearch.tar
scp -r elasticsearch.tar root@10.200.254.53:/root/efk
docker load <elasticsearch.tar


docker save fluent:local>fluent.tar
scp -r fluent.tar root@10.200.254.53:/root/efk
docker load <fluent.tar


docker save kibana:6.8.2>kibana.tar
scp -r kibana.tar root@10.200.254.53:/root/efk
docker load <kibana.tar

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