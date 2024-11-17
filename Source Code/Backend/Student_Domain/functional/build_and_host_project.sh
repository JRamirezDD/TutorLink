#   Title: build_and_host_project sh Script Source Code
#   Author: Ramirez de Diego, Jorge
#   Date: 2024
#   Code version: 1.0
#   Availability: https://github.com/JRamirezDD/TutorLink

@echo off
echo Stopping and removing existing containers...
docker-compose -p student-domain-functional down

echo Building and starting new containers...
docker-compose -p student-domain-functional up --build