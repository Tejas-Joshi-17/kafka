# kafka
Just for learning kafka

1. start server

```bash
  UUID=$(sudo bin/kafka-storage.sh random-uuid | awk '{print $1}')
  sudo bin/kafka-storage.sh format -t $UUID -c config/kraft/server.properties
  sudo bin/kafka-server-start.sh config/kraft/server.properties
```
