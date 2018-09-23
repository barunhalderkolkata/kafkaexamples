#!/usr/bin/env bash

# Make sure you change the ADV_HOST variable in docker-compose.yml
# if you are using docker toolbox

# Start our kafka cluster
docker-compose up kafka-cluster

# We start a hosted tools
docker run --rm -it --name=kafka-cluster --net=host landoop/fast-data-dev bash