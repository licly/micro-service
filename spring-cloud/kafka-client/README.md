进入kafka安装目录
##启动zookeeper
nohup bin/zookeeper-server-start.sh config/zookeeper.properties > /logs/kafka/zookeeper.log 2>&1 &
<br/>端口2181
##停止zookeeper
bin/zookeeper-server-stop.sh

##启动kafka-server
nohup bin/kafka-server-start.sh config/server.properties > /logs/kafka/kafka-server.log 2>&1 & 
<br/>端口9092
##停止kafka-server
bin/kafka-server-stop.sh