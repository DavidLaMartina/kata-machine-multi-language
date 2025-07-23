#!/bin/bash

# Clear all generated day directories
echo "🐍 Clearing all Python kata days..."

# Remove all day directories
rm -rf kata/day*
rm -f stats.json

echo "✅ All kata days cleared!"
echo "🔄 Ready for a fresh start with: ./generate.sh"