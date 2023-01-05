Component Tests
Build Spring Boot application jar:

```bash
  mvn clean install
```


### Build Docker container:

```bash
  docker build -t ct/kafka-streams-demo .
```

### Run docker container
```bash
  docker run -p 18080:8080 --name=stream-kafka-name ct/kafka-streams-demo
```


### Run tests:
```bash
    mvn test -Pcomponent
```
### Run tests leaving containers running (for further test runs):
```bash
    mvn test -Pcomponent -Dcontainers.stayup
```


### Inspecting Kafka Topics
View consumer groups:  
```bash
    docker exec -it reverent_goodall  /bin/sh /usr/bin/kafka-consumer-groups --bootstrap-server localhost:9092 --list
```



## Kafka topology
### APi
```http request
   http://localhost:9001/v1/kafka-streams/topology
```

### Topology visualizer
```bash
   https://zz85.github.io/kafka-streams-viz/
```


### Demo
```
topologies:
   Sub-topology: 0
    Source: KSTREAM-SOURCE-0000000000 (topics: [payment-topic])
      --> KSTREAM-PEEK-0000000001
    Processor: KSTREAM-PEEK-0000000001 (stores: [])
      --> KSTREAM-FILTER-0000000002
      <-- KSTREAM-SOURCE-0000000000
    Processor: KSTREAM-FILTER-0000000002 (stores: [])
      --> KSTREAM-PEEK-0000000003
      <-- KSTREAM-PEEK-0000000001
    Processor: KSTREAM-PEEK-0000000003 (stores: [])
      --> KSTREAM-BRANCH-0000000004
      <-- KSTREAM-FILTER-0000000002
    Processor: KSTREAM-BRANCH-0000000004 (stores: [])
      --> KSTREAM-BRANCHCHILD-0000000006, KSTREAM-BRANCHCHILD-0000000005
      <-- KSTREAM-PEEK-0000000003
    Processor: KSTREAM-BRANCHCHILD-0000000006 (stores: [])
      --> KSTREAM-MAPVALUES-0000000007
      <-- KSTREAM-BRANCH-0000000004
    Processor: KSTREAM-BRANCHCHILD-0000000005 (stores: [])
      --> KSTREAM-MERGE-0000000008
      <-- KSTREAM-BRANCH-0000000004
    Processor: KSTREAM-MAPVALUES-0000000007 (stores: [])
      --> KSTREAM-MERGE-0000000008
      <-- KSTREAM-BRANCHCHILD-0000000006
    Processor: KSTREAM-MERGE-0000000008 (stores: [])
      --> KSTREAM-PEEK-0000000009
      <-- KSTREAM-BRANCHCHILD-0000000005, KSTREAM-MAPVALUES-0000000007
    Processor: KSTREAM-PEEK-0000000009 (stores: [])
      --> KSTREAM-BRANCH-0000000015, KSTREAM-MAP-0000000010
      <-- KSTREAM-MERGE-0000000008
    Processor: KSTREAM-BRANCH-0000000015 (stores: [])
      --> KSTREAM-BRANCHCHILD-0000000016, KSTREAM-BRANCHCHILD-0000000017
      <-- KSTREAM-PEEK-0000000009
    Processor: KSTREAM-MAP-0000000010 (stores: [])
      --> balance-repartition-filter
      <-- KSTREAM-PEEK-0000000009
    Processor: KSTREAM-BRANCHCHILD-0000000016 (stores: [])
      --> KSTREAM-SINK-0000000018
      <-- KSTREAM-BRANCH-0000000015
    Processor: KSTREAM-BRANCHCHILD-0000000017 (stores: [])
      --> KSTREAM-SINK-0000000019
      <-- KSTREAM-BRANCH-0000000015
    Processor: balance-repartition-filter (stores: [])
      --> balance-repartition-sink
      <-- KSTREAM-MAP-0000000010
    Sink: KSTREAM-SINK-0000000018 (topic: rails-foo-topic)
      <-- KSTREAM-BRANCHCHILD-0000000016
    Sink: KSTREAM-SINK-0000000019 (topic: rails-bar-topic)
      <-- KSTREAM-BRANCHCHILD-0000000017
    Sink: balance-repartition-sink (topic: balance-repartition)
      <-- balance-repartition-filter

  Sub-topology: 1
    Source: balance-repartition-source (topics: [balance-repartition])
      --> KSTREAM-AGGREGATE-0000000011
    Processor: KSTREAM-AGGREGATE-0000000011 (stores: [balance])
      --> none
      <-- balance-repartition-source

```


Docker Commands
Manual clean up (if left containers up): 
```
    docker rm -f $(docker ps -aq)
```


tutorial link
```
    https://github.com/lydtechconsulting/kafka-streams/tree/v1.3.0
```

How to fix:
```
MissingSourceTopicException: One or more source topics were missing during rebalance
```

topics should be created before application run 

