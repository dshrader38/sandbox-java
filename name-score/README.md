# Getting Started
## Build & Test
### All Modules
```
gradle build
```
### Calculator Library
```
gradle :name-score-calculator:build
```
### Command-Line Interface (CLI)
```
gradle :name-score-cli:build
```
### Rest Service (API)
```
gradle :name-score-api:build
```
## Run
### [Default] Rest Service (API)
```
gradle bootRun
```
### Command-Line Interface (CLI)
```
gradle :name-score-cli:bootRun
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

docker exec -it <name> bash
```
## Commands
### Command-Line Interface (CLI)
```
score-file --strategy [options] --csv-file [file]
```
#### Samples
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

##
curl -v 'http://localhost:8080/shrader/name-score?strategy=primary'
curl -v 'http://localhost:8080/shrader/name-score/add?lhs=10&rhs=28'
