@echo off

cd /D %~dp0
del /q *.jar >nul

echo Building...
cd /D ../
powershell -c "./gradlew :fabric:build"
powershell -c "./gradlew :neoforge:build"

cd /D %~dp0
echo Moving files...
move ..\fabric\build\libs\*.jar . >nul
move ..\neoforge\build\libs\*.jar . >nul

echo Deleting shadow jars...
del /q *dev-shadow.jar >nul

echo Done.
pause >nul