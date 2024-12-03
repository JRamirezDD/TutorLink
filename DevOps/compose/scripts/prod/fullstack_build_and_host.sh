#!/bin/sh

# Title: fullstack_build_and_host.sh
# Author: Ramirez de Diego, Jorge
# Date: 2024
# Code version: 1.0
# Availability: https://github.com/JRamirezDD/TutorLink

# Enable error handling
# set -e

# script directory
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"

# Define relative paths
CONFIG_FILE="$SCRIPT_DIR/../../env/prod.env.yml"
ENV_FILE="$SCRIPT_DIR/../../env/.env.prod"

# Ensure files exist and resolve absolute paths
if [ ! -f "$CONFIG_FILE" ]; then
    echo "Configuration file not found: $CONFIG_FILE"
    read -p "Press Enter to close..."
    exit 1
fi
CONFIG_FILE=$(realpath "$CONFIG_FILE")
echo "Absolute Configuration File: $CONFIG_FILE"

if [ ! -f "$ENV_FILE" ]; then
    echo "Environment file not found: $ENV_FILE"
    read -p "Press Enter to close..."
    exit 1
fi
ENV_FILE=$(realpath "$ENV_FILE")
echo "Absolute Environment File: $ENV_FILE"
# env_file needs to be exported as an environment variable in linux
export ENV_FILE

# Run config file parsing script
python3 ../yml_env_parser.py "$CONFIG_FILE" "$ENV_FILE"
if [ $? -ne 0 ]; then
    echo "Python script failed."
    read -p "Press Enter to close..."
    exit 1
fi

# Load environment variables
# Load and export environment variables
while IFS='=' read -r VAR VAL || [ -n "$VAR" ]; do
    # Skip empty lines and comments
    if [ -n "$VAR" ] && [ "${VAR#\#}" = "$VAR" ]; then
        # Replace invalid characters in variable names
        VAR_CLEAN=$(echo "$VAR" | sed 's/[^a-zA-Z0-9_]/_/g')
        
        echo "Setting variable: $VAR_CLEAN=$VAL"
        export "$VAR_CLEAN"="$VAL"
    fi
done < "$ENV_FILE"


# Shut down existing Docker containers
docker-compose -f ../../docker-compose-backend-all.yml down
docker-compose -f ../../docker-compose-backend-matchmaking-domain.yml down
docker-compose -f ../../docker-compose-backend-tutor-domain.yml down
docker-compose -f ../../docker-compose-backend-student-domain.yml down
docker-compose -f ../../docker-compose-frontend.yml down
docker-compose -f ../../docker-compose-fullstack.yml down

# Build and run full-stack
docker-compose --env-file "$ENV_FILE" -f ../../docker-compose-fullstack.yml up --build
if [ $? -ne 0 ]; then
    echo "Docker Compose failed."
    read -p "Press Enter to close..."
    exit 1
fi

echo "Build and hosting completed successfully."
