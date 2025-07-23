# Kata Machine Go

A Go implementation of the kata-machine leetcode-style problem solving course. This provides the same "day" generation system that allows you to practice data structures and algorithms with a clean slate each time.

## Features

- **Day Generation**: Create new practice sessions with blank implementations
- **Multiple Data Structures**: Lists, stacks, queues, trees, graphs, and more
- **Algorithm Practice**: Sorting, searching, traversals, and graph algorithms  
- **Automated Testing**: Go testing framework with testify assertions
- **Progress Tracking**: Statistics track how many times you've practiced each algorithm
- **Modern Go**: Uses generics, interfaces, and idiomatic Go patterns

## Requirements

- Go 1.21 or higher

## Quick Start

1. **Setup**
   ```bash
   cd go-kata
   go mod tidy  # Download dependencies
   ```

2. **Generate Your First Day**
   ```bash
   ./generate.sh
   ```
   This creates `day1/` directory with skeleton implementations.

3. **Run Tests**
   ```bash
   go test -v        # Run all tests
   ./test.sh Linear  # Run specific tests by pattern (like npx jest Linear)
   ./test.sh         # Run all tests (same as go test -v)
   ```

4. **Implement Algorithms**
   - Open the generated files in `day1/`
   - Implement the empty functions/methods
   - Run tests to verify your solutions

5. **Generate Next Day**
   ```bash
   ./generate.sh
   ```
   Creates `day2/` with fresh blank implementations for more practice.

## Configuration

Edit `kata_config.json` to choose which algorithms to practice:

```json
{
    "dsa": [
        "BubbleSort",
        "Queue", 
        "Stack",
        "ArrayList",
        "BinarySearchList",
        "LinearSearchList"
    ]
}
```

## Available Algorithms

### Data Structures
- `ArrayList[T]` - Dynamic array implementation with generics
- `SinglyLinkedList[T]` - Singly linked list
- `DoublyLinkedList[T]` - Doubly linked list  
- `Queue[T]` - FIFO queue
- `Stack[T]` - LIFO stack
- `MinHeap` - Min heap implementation
- `Trie` - Prefix tree
- `Map[K, V]` - Hash map implementation with generics
- `LRU[K, V]` - LRU cache with generics

### Algorithms
- `BubbleSort` - Bubble sort algorithm
- `QuickSort` - Quick sort algorithm
- `BinarySearch` - Binary search on sorted array
- `LinearSearch` - Linear search
- `TwoCrystalBalls` - Two crystal balls problem
- `Solve` - Maze solving algorithm

### Tree Operations
- `PreOrderSearch` - Binary tree pre-order traversal
- `InOrderSearch` - Binary tree in-order traversal  
- `PostOrderSearch` - Binary tree post-order traversal
- `BFS` - Binary tree breadth-first search
- `Compare` - Compare two binary trees
- `DFS` - Depth-first search on BST

### Graph Operations
- `DFS` - DFS on adjacency list graph
- `BFS` - BFS on adjacency matrix graph

## Commands

```bash
# Generate new practice day
./generate.sh

# Run all tests
go test -v

# Run specific tests by pattern
./test.sh Linear     # Runs LinearSearch test
./test.sh Binary     # Runs BinarySearch test  
./test.sh List       # Runs ArrayList, SinglyLinkedList, DoublyLinkedList tests
./test.sh Stack      # Runs Stack test

# Clear all progress and start over
./clear.sh

# View practice statistics
cat stats.json

# Format code
go fmt ./...

# Check for issues
go vet ./...
```

## How It Works

1. **Configuration**: `kata_config.json` specifies which algorithms to include
2. **Generation**: `./generate.sh` creates a new `dayN` directory with skeleton implementations
3. **Testing**: Go's built-in testing framework verifies your implementations work correctly
4. **Progression**: Each generation creates a new day directory, preserving previous work
5. **Statistics**: `stats.json` tracks how many times you've practiced each algorithm

## Project Structure

```
go-kata/
├── types/
│   └── types.go         # Common data types (Point, BinaryNode, etc.)
├── interfaces/
│   └── interfaces.go    # Interfaces (List, etc.)
├── day1/               # Generated practice files
├── day2/               # Next practice session
├── algorithms_test.go  # Test file
├── list_test.go       # List testing utilities
├── kata_config.json   # Algorithm configuration
├── generator.go       # Generation script
├── generate.sh        # Generation wrapper
├── clear.sh          # Clear all progress
├── go.mod            # Go module definition
└── stats.json        # Practice statistics
```

## Go-Specific Features

- **Generics**: Full generic type support for containers like `List[T]`, `Map[K,V]`
- **Interfaces**: Clean interface definitions for polymorphic behavior
- **Pointers**: Proper pointer usage for optional return values (`*T` instead of `T | undefined`)
- **Methods**: Receiver methods for struct-based data structures
- **Package System**: Organized code with proper Go package structure
- **Testing**: Built-in Go testing with testify for better assertions
- **Memory Safety**: Go's garbage collector handles memory management
- **Fast Compilation**: Quick feedback loop for testing implementations

## Go Syntax Notes

- **Slices**: `[]int` instead of `int[]` or `List[int]`
- **Pointers**: `*T` for nullable/optional values
- **Methods**: `func (s *Stack[T]) Push(item T)` - receiver syntax
- **Interfaces**: Implicit implementation (no `implements` keyword)
- **Zero Values**: `nil` for pointers, `0` for numbers, `false` for bools

## Tips

- Use `make()` for slices/maps: `make([]int, 0)`, `make(map[string]int)`
- Remember Go's zero values - no need to explicitly initialize to defaults
- Use pointer receivers (`*T`) when you need to modify the struct
- Go's `range` is your friend for iterating: `for i, v := range slice`
- Use `_` to ignore unused variables: `for _, value := range slice`

## Original

This is a Go port of [ThePrimeagen's kata-machine](https://github.com/ThePrimeagen/kata-machine) TypeScript course.