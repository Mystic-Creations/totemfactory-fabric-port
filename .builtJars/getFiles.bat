@echo off
echo Moving files...
move ..\fabric\build\libs\*.jar . >nul
move ..\forge\build\libs\*.jar . >nul
echo Deleting shadow jars...
del /q *dev-shadow.jar >nul
echo Done.
timeout 1 >nul