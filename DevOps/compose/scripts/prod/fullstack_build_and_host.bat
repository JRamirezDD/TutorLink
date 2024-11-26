@echo off

REM   Title: fullstack_build_and_host.bat
REM   Author: Ramirez de Diego, Jorge
REM   Date: 2024
REM   Code version: 1.0
REM   Availability: https://github.com/JRamirezDD/TutorLink

REM script directory
set SCRIPT_DIR=%~dp0

REM define relative paths
set CONFIG_FILE="%SCRIPT_DIR%..\..\env\prod.env.yml"
echo Configuration File: %CONFIG_FILE%

set ENV_FILE="%SCRIPT_DIR%..\..\env\.env.prod"
echo Environment File: %ENV_FILE%

REM convert into absolute paths
for %%I in (%CONFIG_FILE%) do set CONFIG_FILE=%%~fI
echo Absolute Configuration File: %CONFIG_FILE%

for %%I in (%ENV_FILE%) do set ENV_FILE=%%~fI
echo Absolute Environment File: %ENV_FILE%

REM run config file parsing script
python ../yml_env_parser.py "%CONFIG_FILE%" "%ENV_FILE%"
if %ERRORLEVEL% NEQ 0 (
    echo Python script failed.
    pause
    exit /b 1
)

REM shut down compose node
docker-compose -f ../../docker-compose-backend.yml down
docker-compose -f ../../docker-compose-frontend.yml down
docker-compose -f ../../docker-compose-fullstack.yml down

REM build up compose node
docker-compose --env-file "%ENV_FILE%" -f ../../docker-compose-fullstack.yml up --build
if %ERRORLEVEL% NEQ 0 (
    echo Docker Compose failed.
    pause
    exit /b 1
)
