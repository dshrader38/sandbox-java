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
scorefile --score-strategy FIRST --csv-file src/main/resources/SmallFile.csv
```
#### SECONDARY -> 3194
```
scorefile --score-strategy SECOND --csv-file src/main/resources/SmallFile.csv
```
#### TERTIARY -> 494
```
scorefile --score-strategy THIRD --csv-file src/main/resources/SmallFile.csv
```
### Error
#### Bad score strategy
```
scorefile --score-strategy TENTH --csv-file src/main/resources/SmallFile.csv
```