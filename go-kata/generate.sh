#!/bin/bash

# Generate a new day of kata practice
echo "🚀 Generating new Go kata day..."

# Run the generator
go run generator.go algorithm_definitions.go

if [ $? -eq 0 ]; then
    echo "✅ Generation complete!"
    echo "📁 Check current directory for your new day folder"
    echo "🧪 Run tests with: go test"
    echo "📊 View stats with: cat stats.json"
else
    echo "❌ Generation failed!"
    exit 1
fi