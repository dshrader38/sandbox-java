# Getting Started
## Build & Run (Java)
```
gradle assemble
java -jar name-score-0.1.1.jar
```
## Build & Run (Docker)
```
docker build -t shrader:latest
docker run --rm -it -v $(pwd):/usr/src/project shrader
docker run --rm -it --mount type=bind,src="$(pwd)",dst=/usr/src/project shrader
--name
```

docker exec -it <name> bash

curl -v http://localhost:8080/name-score?strategy=primary

## Commands
### Valid 
#### PRIMARY -> 494
```
score-file -C src/main/resources/SmallFile.csv
score-file --strategy FIRST --csv-file src/main/resources/SmallFile.csv
```
#### SECONDARY -> 3194
```
score-file --strategy SECOND --csv-file src/main/resources/SmallFile.csv
```
#### TERTIARY -> 494
```
score-file --strategy THIRD --csv-file src/main/resources/SmallFile.csv
```
### Error
#### Bad score strategy
```
scorefile --strategy TENTH --csv-file src/main/resources/SmallFile.csv
```