## Start up instruction
1. 启动 **Redis : 2379**   redisServer.sh     
2. 启动 **Zookeeper : 2181**   bin/zkServer.sh start
3. 启动 **RocketMQ**  
    - nohup sh bin/mqnamesrv &
    - tail -f ~/logs/rocketmqlogs/namesrv.log
    - nohup sh bin/mqbroker -n localhost:9876 &
    - tail -f ~/logs/rocketmqlogs/broker.log
4. **Docker**命令：
    - **RocketMQ Broker** docker run -d -p 10911:10911 -p 10909:10909 -v `pwd`/data/broker/logs:/root/logs -v `pwd`/data/broker/store:/root/store --name rmq-broker --link rmq-namesrv:rmq-namesrv -e "NAMESRV_ADDR=172.17.0.6:9876" -e "MAX_POSSIBLE_HEAP=200000000" rocketmqinc/rocketmq sh mqbroker -c /opt/rocketmq-4.4.0/conf/broker.conf
    - **RocketMQ NameServer** docker run -d -p 9876:9876 -v `pwd`/data/namesrv/logs:/root/logs -v `pwd`/data/namesrv/store:/root/store --name rmq-namesrv -e "MAX_POSSIBLE_HEAP=100000000" rocketmqinc/rocketmq sh mqnamesrv
    - **Nginx** docker run --detach --publish=80:80 --name=webserver nginx
    - **Mysql** docker run --name mysql -e MYSQL_ROOT_PASSWORD=12345678 -d mysql:latest
    - **Redis** docker run --name redis -p 6379:6379 -d redis
    - **Zookeeper** docker run --name zookeeper -p 2181:2181 --restart always -d zookeeper
    - **RocketMQ Admin** docker run -e "JAVA_OPTS=-Drocketmq.namesrv.addr=172.17.0.6:9876 -Dcom.rocketmq.sendMessageWithVIPChannel=false" -p 8080:8080 --name rmq-admin --detach -t styletang/rocketmq-console-ng
> 注意：
>  * broker.conf 文件里需要添加brokerIP1=127.0.0.1
>  * docker pull慢可以加镜像地址:C:\Users\PrimoKang\.docker 中："registry-mirrors": ["http://f2d6cb40.m.daocloud.io"]


## TODO
1. 找到阴历和阳历日期相同的多少年内的所有天：输入：可以是阳历，也可以是阴历日期、年的区间、日期。
