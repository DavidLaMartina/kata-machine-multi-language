#!/bin/bash

# Generate a new day of kata practice
echo "Generating new kata day..."

# Compile and run the generator
mvn compile exec:java -Dexec.mainClass="com.kata.Generator" -q

if [ $? -eq 0 ]; then
    echo "✅ Generation complete!"
    echo "📁 Check src/main/java/com/kata/ for your new day folder"
    echo "🧪 Run tests with: mvn test"
    echo "📊 View stats with: cat stats.json"
else
    echo "❌ Generation failed!"
    exit 1
fi