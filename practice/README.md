## Start up instruction
1. 启动 **Redis : 2379**   redisServer.sh     
2. 启动 **Zookeeper : 2181**   bin/zkServer.sh start
3. 启动 **RocketMQ**  
    - nohup sh bin/mqnamesrv &
    - tail -f ~/logs/rocketmqlogs/namesrv.log
    - nohup sh bin/mqbroker -n localhost:9876 &
    - tail -f ~/logs/rocketmqlogs/broker.log

## TODO
1. 找到阴历和阳历日期相同的多少年内的所有天：输入：可以是阳历，也可以是阴历日期、年的区间、日期。
