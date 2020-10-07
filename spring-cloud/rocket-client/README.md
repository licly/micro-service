#启动name-server
nohup sh bin/mqnamesrv &
tail -f ~/logs/rocketmqlogs/namesrv.log 查看日志
#启动broker
nohup sh bin/mqbroker -n localhost:9876 &
tail -f ~/logs/rocketmqlogs/broker.log  查看日志

#发生问题
可能由于内存不足导致broker、name-server启动不了，配置一下runbroker.sh、runserver.sh里分配的内存即可