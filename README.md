.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties  
 
.\bin\windows\kafka-server-start.bat .\config\server.properties  

.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 6 --topic kafka-topic2  

.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list

.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic kafka-topic 

.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic kafka-topic --from-beginning  
