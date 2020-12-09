FROM openjdk:12

VOLUME /tmp

#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar

# Use an official Python runtime as a parent image
#FROM python:2.7-slim

# Set the working directory to /app
#WORKDIR /app

# Copy the current directory contents into the container at /app
#COPY . /app

# Make port 80 available to the world outside this container
#EXPOSE 80

# Define environment variable
ENV NAME World

ADD build/libs/name-score-0.1.1.jar app.jar

RUN bash -c 'touch app.jar'

#ENTRYPOINT ["java","-jar","/name-score-0.1.1.jar"]
ENTRYPOINT ["java","-jar","/app.jar"]
