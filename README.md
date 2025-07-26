# kafka

Just for learning kafka

1. start server

```sh
  UUID=$(sudo bin/kafka-storage.sh random-uuid | awk '{print $1}') 
  sudo bin/kafka-storage.sh format -t $UUID -c config/kraft/server.properties 
  sudo bin/kafka-server-start.sh config/kraft/server.properties
``

2. create a topic

```sh
sudo bin/kafka-topic.sh --create \
  --bootstrap-server localhost:9092 \
  --partitions 1 \
  --replication-factor 1 \
  --topic test-topic-2 
```

3. Producer Console

```sh
sudo ./bin/kafka-console-producer.sh \
  --bootstrap-server localhost:9092 \
  --topic test-topic-1
```

4. Consumer Console

```sh
sudo ./bin/kafka-console-consumer.sh \
  --bootstrap-server localhost:9092 \
  --topic test-topic-1 \
  --from-beginning
```

5. Start Producer & Send message using key so that it will distribute among both partitions 
   
```sh
sudo ./bin/kafka-console-producer.sh \
  --bootstrap-server localhost:9092 \
  --topic orders 
  --property parse.key=true
  --property key.separator=:
```

6. Create Two consumers connected to topic part of same group

```sh
sudo ./bin/kafka-console-consumer.sh \
  --bootstrap-server localhost:9092 \
  --topic orders \
  --group waiters
```
