# Kafka-with_Springboot

Commands


zookeeper=2181
kafka -9092   port
to run zookeeper server- bin\windows\zookeeper-server-start.bat config\zookeeper.properties
to run kafka srver - bin\windows\kafka-server-start.bat config\server.properties


to create topic - bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic kafkalearn-Topic-2 --partitions 3 --replication-factor 1
to see topic    - bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list
topic describe  - bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic kafkalearn-Topic

run producer - bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic kafkalearn-Topic
to start consumer - bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic kafkalearn-Topic --from-beginning
 
