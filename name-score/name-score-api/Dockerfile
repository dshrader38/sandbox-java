FROM openjdk:12

VOLUME /tmp

#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar

# Set the working directory to /app
#WORKDIR /app

# Copy the current directory contents into the container at /app
#COPY . /app

# Make port 80 available to the world outside this container
EXPOSE 8080

# Define environment variable
ENV NAME HelloWorld
ADD build/libs/name-score-api-0.0.1.jar name-score-api.jar
RUN bash -c 'touch name-score-api.jar'
ENTRYPOINT ["java","-jar","/name-score-api.jar"]
