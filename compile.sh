#!/bin/bash

ROOT_DIR="."
BUILD_DIR="./build"

# Clean build
if [ -d "$BUILD_DIR" ]; then
    echo "🧹 Cleaning previous build..."
    rm -rf "$BUILD_DIR"
fi

mkdir -p "$BUILD_DIR"

# Find all .java files recursively, excluding build dir
echo "🔍 Searching for .java files..."
find "$ROOT_DIR" -type f -name "*.java" ! -path "$BUILD_DIR/*" > sources.txt

if [ ! -s sources.txt ]; then
    echo "❌ No Java source files found."
    rm sources.txt
    exit 1
fi

echo "✅ Found Java files:"
cat sources.txt

# Compile to build/
javac -d "$BUILD_DIR" @sources.txt
rm sources.txt

echo "✅ Compilation successful! Classes are in '$BUILD_DIR'."
