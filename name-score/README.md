# Getting Started
## Build & Run (Java)
```
gradle assemble
java -jar name-score-0.1.1.jar
```
## Build & Run (Docker)
```
docker build -t shrader:latest .
docker run -it -v $(pwd):/usr/src/project shrader
```
## Commands
### Valid 
#### ABECEDARIAN_SCORE -> 494
```
scorefile --score-strategy ABECEDARIAN_SCORE --csv-file src/main/resources/SmallFile.csv
```
#### BASIC_SCORE -> 3194
```
scorefile --score-strategy BASIC_SCORE --csv-file src/main/resources/SmallFile.csv
```
#### BETTER_SCORE -> 494
```
scorefile --score-strategy BETTER_SCORE --csv-file src/main/resources/SmallFile.csv
```
### Error
#### Bad score strategy
```
scorefile --score-strategy UNKNOWN_SCORE --csv-file src/main/resources/SmallFile.csv
```