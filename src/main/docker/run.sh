#!/bin/sh

echo "********************************************************"
echo "Starting loadtestes Service"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -Dserver.port=$SERVER_PORT   \
     -Dspring.profiles.active=$PROFILE -jar /usr/local/loadtestes/loadtestes-0.0.1-SNAPSHOT.jar