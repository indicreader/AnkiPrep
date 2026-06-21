@echo off
setlocal enabledelayedexpansion
echo ===================================================
echo 🚀 FAST UPDATE COMPILATION PIPELINE (INCREMENTAL)
echo ===================================================

:: Setup destination directory
set "RELEASE_DIR=release"
if not exist "%RELEASE_DIR%" mkdir "%RELEASE_DIR%"

echo [1/3] Skipping clean. Incrementing app version...
call python increment_version.py
set "VERSION=1.0"
for /f "tokens=2 delims==" %%a in ('findstr /c:"versionName =" app\build.gradle.kts 2^>nul') do (
    set "VAL=%%a"
    set "VAL=!VAL: =!"
    set "VAL=!VAL:"=!"
    set "VERSION=!VAL!"
)
echo Verified Project Version Name: !VERSION!

echo [2/3] Compiling changes (incremental assembleDebug)...
call .\gradlew.bat assembleDebug

echo [3/3] Locating and copying updated APK...
set "BUILT_APK="
for /r "app\build\outputs\apk" %%f in (*.apk) do (
    set "BUILT_APK=%%f"
)
if not defined BUILT_APK (
    for /r "build\outputs\apk" %%f in (*.apk) do (
        set "BUILT_APK=%%f"
    )
)

if defined BUILT_APK (
    copy /y "%BUILT_APK%" "%RELEASE_DIR%\ankiprep-!VERSION!.apk" >nul
    echo.
    echo ✅ SUCCESS: Output updated successfully.
    echo 📦 File Saved At: %RELEASE_DIR%\ankiprep-!VERSION!.apk
) else (
    echo ❌ ERROR: Compilation finished but binary assets were missing.
    exit /b 1
)
endlocal
