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