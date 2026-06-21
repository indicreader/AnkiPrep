@echo off
setlocal enabledelayedexpansion
echo ===================================================
echo 🚀 LOCALIZING ANDROID APK COMPILATION PIPELINE
echo ===================================================

:: Setup destination directory
set "RELEASE_DIR=release"
if not exist "%RELEASE_DIR%" mkdir "%RELEASE_DIR%"

echo [1/4] Cleaning project architectures...
call .\gradlew.bat clean

echo [2/4] Incrementing and extracting app version name dynamically...
call python increment_version.py
set "VERSION=1.0"
for /f "tokens=2 delims==" %%a in ('findstr /c:"versionName =" app\build.gradle.kts 2^>nul') do (
    set "VAL=%%a"
    set "VAL=!VAL: =!"
    set "VAL=!VAL:"=!"
    set "VERSION=!VAL!"
)
echo Verified Project Version Name: !VERSION!

echo [3/4] Generating fresh application assets...
call .\gradlew.bat assembleRelease

echo [4/4] Activating custom naming convention...
:: Locate the standard newly built apk path
set "BUILT_APK="
for /r "app\build\outputs\apk" %%f in (*.apk) do (
    set "BUILT_APK=%%f"
)
if not defined BUILT_APK (
    for /r "build\outputs\apk" %%f in (*.apk) do (
        set "BUILT_APK=%%f"
    )
)

:: Rename and route to release folder

if defined BUILT_APK (
    copy /y "%BUILT_APK%" "%RELEASE_DIR%\ankiprep-!VERSION!.apk" >nul
    echo.
    echo ✅ SUCCESS: Output compiled successfully.
    echo 📦 File Saved At: %RELEASE_DIR%\ankiprep-!VERSION!.apk
) else (
    echo ❌ ERROR: Compilation finished but binary assets were missing.
    exit /b 1
)
endlocal
