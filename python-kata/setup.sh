#!/bin/bash

echo "🐍 Setting up Python kata machine..."

# Create virtual environment if it doesn't exist
if [ ! -d "venv" ]; then
    echo "Creating virtual environment..."
    python3 -m venv venv
fi

# Activate virtual environment
echo "Activating virtual environment..."
source venv/bin/activate

# Install requirements
echo "Installing requirements..."
pip install -r requirements.txt

echo "✅ Setup complete!"
echo "🔥 To activate the environment: source venv/bin/activate"
echo "🚀 Then run: ./generate.sh"