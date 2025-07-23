#!/bin/bash

# Clear all generated day directories
echo "Clearing all kata days..."

# Remove all day directories
rm -rf src/main/java/com/kata/day*
rm -f stats.json

# Reset pom.xml to day1
sed -i.bak 's/<current\.day>day[0-9]*<\/current\.day>/<current.day>day1<\/current.day>/' pom.xml
rm -f pom.xml.bak

echo "✅ All kata days cleared!"
echo "🔄 Ready for a fresh start with: ./generate.sh"