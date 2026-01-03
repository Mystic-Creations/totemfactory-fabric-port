@echo off
echo Moving files...
move ..\fabric\build\libs\*.jar . >nul
move ..\neoforge\build\libs\*.jar . >nul

timeout /t 3 /nobreak >nul
echo Deleting shadow jars...
del /q *dev-shadow.jar >nul

timeout 3 >nul