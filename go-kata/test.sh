#!/bin/bash

# Run specific tests by pattern matching
# Usage: ./test.sh Linear  (runs any test containing "Linear")
# Usage: ./test.sh        (runs all tests)

if [ $# -eq 0 ]; then
    # No arguments - run all tests
    go test -v
else
    # Pattern provided - run matching tests
    echo "🧪 Running tests matching pattern: *$1*"
    
    # Run the test and capture the result
    if go test -v -run "$1"; then
        echo "✅ All tests matching '*$1*' passed!"
    else
        echo "❌ Some tests matching '*$1*' failed."
        exit 1
    fi
fi