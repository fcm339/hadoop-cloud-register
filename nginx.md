#nginx配置https
        
            server
            {
                listen 443 ssl;
                server_name contract_dev.ysservice.com.cn;
                #ssl start
                ssl_certificate conf.d/cert/2834425__ysservice.com.cn.pem; #将domain name.pem替换成您证书的文件名。
                ssl_certificate_key conf.d/cert/2834425__ysservice.com.cn.key; #将domain name.key替换成您证书的私钥文件名。
                ssl_session_timeout 500m;
                # 使用此加密套件。
                ssl_ciphers ECDHE-RSA-AES128-GCM-SHA256:ECDHE:ECDH:AES:HIGH:!NULL:!aNULL:!MD5:!ADH:!RC4;
                ssl_protocols TLSv1 TLSv1.1 TLSv1.2;   # 修改protocols。
                ssl_prefer_server_ciphers on;
                #ssl end
                #PROXY-START/
            
                location /api/
                {
                    expires 0;
                    proxy_pass http://10.200.254.53:8080/;
                    proxy_set_header X-Real-IP $remote_addr;
                    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
                    proxy_set_header REMOTE-HOST $remote_addr;
            
                    #持久化连接相关配置
                    #proxy_connect_timeout 30s;
                    #proxy_read_timeout 86400s;
                    #proxy_send_timeout 30s;
                    #proxy_http_version 1.1;
                    #proxy_set_header Upgrade $http_upgrade;
                    #proxy_set_header Connection "upgrade";
            
                    add_header X-Cache $upstream_cache_status;
            
                }
            
                location /
                {
                    expires 0;
                    proxy_pass http://10.200.254.53:3001/;
                    proxy_set_header X-Real-IP $remote_addr;
                    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
                    proxy_set_header REMOTE-HOST $remote_addr;
            
                    #持久化连接相关配置
                    #proxy_connect_timeout 30s;
                    #proxy_read_timeout 86400s;
                    #proxy_send_timeout 30s;
                    #proxy_http_version 1.1;
                    #proxy_set_header Upgrade $http_upgrade;
                    #proxy_set_header Connection "upgrade";
            
                    add_header X-Cache $upstream_cache_status;
                }
            
            
                access_log  /var/log/nginx/contract_dev.log;
                error_log  /var/log/nginx/contract_dev.error.log;
            }
            


