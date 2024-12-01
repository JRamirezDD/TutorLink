REM   Title: build_and_save_image Bat Script Source Code
REM   Author: Ramirez de Diego, Jorge
REM   Date: 2024
REM   Code version: 1.0
REM   Availability: https://github.com/JRamirezDD/TutorLink


@echo off
SETLOCAL EnableDelayedExpansion

REM Change directory to the script's location
cd /d "%~dp0"
echo Current directory: %cd%

REM Define variables
SET PROJECT_DIR=.
SET GRADLE_VERSION=8.10.2
SET GRADLE_DIR=\.gradle\"%GRADLE_VERSION%"

REM Step 0: Ensure gradle wrapper exists
echo Checking Gradle wrapper is of version "%GRADLE_VERSION%"...
IF NOT EXIST "%GRADLE_DIR%" call gradle wrapper --gradle-version "%GRADLE_VERSION%"

REM Step 1: Build the Gradle project
echo Building Gradle project...
call gradlew.bat build

IF NOT "%ERRORLEVEL%" == "0" (
    echo Gradle build failed, exiting...
    exit /b 1
)

echo Process completed successfully.
ENDLOCAL