#!/bin/bash

# Title: fullstack_build_and_host.sh
# Author: Ramirez de Diego, Jorge
# Date: 2024
# Code version: 1.0
# Availability: https://github.com/JRamirezDD/TutorLink

# script directory
SCRIPT_DIR=$(dirname "$(realpath "$0")")

# define relative paths
CONFIG_FILE="${SCRIPT_DIR}/../../env/prod.env.yml"
echo "Configuration File: $CONFIG_FILE"

ENV_FILE="${SCRIPT_DIR}/../../env/.env.prod"
echo "Environment File: $ENV_FILE"

# convert into absolute paths
CONFIG_FILE=$(realpath "$CONFIG_FILE")
echo "Absolute Configuration File: $CONFIG_FILE"

ENV_FILE=$(realpath "$ENV_FILE")
echo "Absolute Environment File: $ENV_FILE"

# run config file parsing script
python3 ../yml_env_parser.py "$CONFIG_FILE" "$ENV_FILE"
if [ $? -ne 0 ]; then
    echo "Python script failed."
    exit 1
fi

# shut down compose node
docker-compose -f ../../docker-compose-backend.yml down
docker-compose -f ../../docker-compose-frontend.yml down
docker-compose -f ../../docker-compose-fullstack.yml down

# build up compose node
docker-compose --env-file "$ENV_FILE" -f ../../docker-compose-fullstack.yml up --build
if [ $? -ne 0 ]; then
    echo "Docker Compose failed."
    exit 1
fi
