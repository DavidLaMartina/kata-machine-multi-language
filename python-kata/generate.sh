#!/bin/bash

# Generate a new day of kata practice
echo "🐍 Generating new Python kata day..."

# Run the generator
python3 generator.py

if [ $? -eq 0 ]; then
    echo "✅ Generation complete!"
    echo "📁 Check kata/ directory for your new day folder"
    echo "🧪 Run tests with: pytest"
    echo "📊 View stats with: cat stats.json"
else
    echo "❌ Generation failed!"
    exit 1
fi