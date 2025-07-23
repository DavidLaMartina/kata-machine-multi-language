#!/bin/bash

# Clear all generated day directories
echo "🚀 Clearing all Go kata days..."

# Remove all day directories
rm -rf day*
rm -f stats.json

echo "✅ All kata days cleared!"
echo "🔄 Ready for a fresh start with: ./generate.sh"