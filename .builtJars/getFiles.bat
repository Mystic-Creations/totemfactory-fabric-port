@echo off
echo Moving files...
move ..\fabric\build\libs\*.jar . >nul
move ..\forge\build\libs\*.jar . >nul
::left this for when we'll do 1.21.1
::move ..\neoforge\build\libs\*.jar . >nul

timeout /t 3 /nobreak >nul
echo Deleting shadow jars...
del /q *dev-shadow.jar >nul

timeout 3 >nul