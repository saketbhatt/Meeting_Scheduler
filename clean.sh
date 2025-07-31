#!/bin/bash

BUILD_DIR="./build"

echo "🧹 Cleaning build artifacts..."

# Delete build directory if it exists
if [ -d "$BUILD_DIR" ]; then
    rm -rf "$BUILD_DIR"
    echo "✅ Deleted $BUILD_DIR"
else
    echo "ℹ️ No build/ directory found to clean."
fi

# Optionally, clean any stray .class files elsewhere (if needed)
find . -type f -name "*.class" -delete

echo "✅ Clean complete."
