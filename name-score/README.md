# Getting Started
## Build/Test
### Gradle
```
gradle build
```
## Run
### Gradle
```
gradle :name-score-shell:bootRun
```
### Java
```
java -jar name-score-shell/build/libs/name-score-shell-0.0.1.jar
```
### Docker
```
docker build -t shrader:latest
docker run --rm -it -v $(pwd):/usr/src/project shrader
docker run --rm -it --mount type=bind,src="$(pwd)",dst=/usr/src/project shrader
--name
```

docker exec -it <name> bash

## Commands
### Valid 
#### PRIMARY -> 494
````
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
score-file --strategy TENTH --csv-file src/main/resources/SmallFile.csv
```


curl -v http://localhost:8080/name-score?strategy=primary
curl -v http://localhost:8080/name-score/add?lhs=10&rhs=28
