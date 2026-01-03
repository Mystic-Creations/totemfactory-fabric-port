#!/bin/bash

echo "Moving files..."
mv ../fabric/build/libs/*.jar . 2>/dev/null
mv ../neoforge/build/libs/*.jar . 2>/dev/null

sleep 3

echo "Deleting shadow jars..."
rm -f *dev-shadow.jar 2>/dev/null

sleep 3
