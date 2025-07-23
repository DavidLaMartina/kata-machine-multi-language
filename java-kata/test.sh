#!/bin/bash

# Run specific tests by pattern matching
# Usage: ./test.sh Linear  (runs any test method containing "Linear")
# Usage: ./test.sh        (runs all tests)

if [ $# -eq 0 ]; then
    # No arguments - run all tests
    mvn test
else
    # Pattern provided - run matching tests by method name
    echo "🧪 Running tests matching pattern: *$1*"
    
    # Run the test and capture the result
    if mvn test -Dtest="AlgorithmTest#*${1}*" -Dsurefire.failIfNoSpecifiedTests=false -q; then
        echo "✅ All tests matching '*$1*' passed!"
    else
        echo "❌ Some tests matching '*$1*' failed."
        exit 1
    fi
fi