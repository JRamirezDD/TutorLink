REM   Title: build-script Bat Script Source Code
REM   Author: Ramirez de Diego, Jorge
REM   Date: 2024
REM   Code version: 1.0
REM   Availability: https://github.com/JRamirezDD/TutorLink

#!/bin/bash

echo "Stopping and removing existing containers..."
docker-compose -p student-domain-functional down

echo "Building and starting new containers..."
docker-compose -p student-domain-functional up --build