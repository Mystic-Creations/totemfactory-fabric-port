#!/bin/bash

echo "Moving files..."
mv ../fabric/build/libs/*.jar . 2>/dev/null
mv ../forge/build/libs/*.jar . 2>/dev/null
# left this for when we'll do 1.21.1
# mv ../neoforge/build/libs/*.jar . 2>/dev/null

sleep 3

echo "Deleting shadow jars..."
rm -f *dev-shadow.jar 2>/dev/null

sleep 3
