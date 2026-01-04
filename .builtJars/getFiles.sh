#!/bin/bash

echo "Moving files..."
mv ../fabric/build/libs/*.jar . 2>/dev/null
mv ../forge/build/libs/*.jar . 2>/dev/null
echo "Deleting shadow jars..."
rm -f *dev-shadow.jar 2>/dev/null
echo "Done."
sleep 1
