@echo off
setlocal enabledelayedexpansion
title Git Auto-Push Wizard

:: Check if the folder is an active Git repository
if not exist ".git" (
    echo [STATUS] Local Git repository not found. Initializing...
    git init
    git branch -M main
    echo.
)

:: Check if a remote URL is already configured
git remote get-url origin >nul 2>&1
if %errorlevel% equ 0 (
    echo [STATUS] Active GitHub remote repository link detected.
    for /f "tokens=*" %%i in ('git remote get-url origin') do set REMOTE_URL=%%i
    echo [TARGET] Link: !REMOTE_URL!
    echo.
    goto STAGE_AND_PUSH
) else (
    echo [STATUS] No GitHub remote repository link detected for this project.
    goto SETUP_REMOTE
)

:SETUP_REMOTE
echo -------------------------------------------------------------------
set /p REPO_URL="Enter your GitHub Repository URL (HTTPS Link): "
echo -------------------------------------------------------------------

:: Basic validation to check if the input is empty
if "%REPO_URL%"=="" (
    echo [ERROR] The repository URL cannot be blank. Please restart the script.
    pause
    exit /b
)

:: Connect the local folder to the provided remote link
git remote add origin %REPO_URL%
git branch -M main
echo [SUCCESS] Remote link configured successfully.
echo.

:STAGE_AND_PUSH
echo [STATUS] Preparing files for deployment...

:: Stage all changed and new files
git add .

:: Prompt user for a custom commit description
set /p COMMIT_MSG="Enter your commit message (or press Enter for default): "
if "%COMMIT_MSG%"=="" set COMMIT_MSG="Update: Automated backup push via script"

:: Save the snapshot locally
git commit -m "%COMMIT_MSG%"

echo.
echo [STATUS] Uploading code to GitHub (main branch)...
echo -------------------------------------------------------------------

:: Execute the upload loop
git push -u origin main

if %errorlevel% equ 0 (
    echo -------------------------------------------------------------------
    echo [SUCCESS] Your project has been successfully uploaded to GitHub!
) else (
    echo -------------------------------------------------------------------
    echo [ERROR] Push failed. If this is a new setup, ensure you use your 
    echo         GitHub Personal Access Token (PAT) as the password prompt key.
)

echo.
pause
exit /b