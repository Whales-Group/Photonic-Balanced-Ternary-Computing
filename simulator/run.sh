#!/bin/bash

# Simple run script for the Photonic simulator
echo "🛠️  Compiling sources..."
javac *.java

if [ $? -ne 0 ]; then
  echo "❌ Compilation failed!"
  exit 1
fi

echo "🚀 Running simulation..."
java PhotonicDotProductSimulator

CSV_PATH="results/benchmark.csv"

if [ -f "$CSV_PATH" ]; then
    echo "📊 Opening benchmark results..."
    open "$CSV_PATH"
else
    echo "⚠️ No benchmark file found at $CSV_PATH"
fi

echo "📂 Results saved in ./results"
