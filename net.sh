#!/usr/bin/env bash

#安装iftop
yum install iftop -y

#查看带宽eth0表示网卡
iftop -i eth0 -n  -P


