# Busy Query Simulator
Simulates a busy reading of query on a application by utilizing threads. Made for IF3140 Database Systems Lab.

## How to run
Steps to run this program:
1. Build the maven with the command
```
mvn clean package
```

2. In the target folder, there will be a file named `if3140lab.10-SNAPSHOT.jar`. This will be the executable JAR file

3. From a directory that contains a file named `query.sql` which contains the query that would be executed, run 
```
java -jar if3140lab.10-SNAPSHOT.jar
```

Example result are as follows:
```
Query processed in: 49ms
```

## Java Version
The Java SDK used to create this program is 19.0.1