# Kata Machine Java

A Java port of the TypeScript kata-machine leetcode-style problem solving course. This implementation provides the same "day" generation system that allows you to practice data structures and algorithms with a clean slate each time.

## Features

- **Day Generation**: Create new practice sessions with blank implementations
- **Multiple Data Structures**: Lists, stacks, queues, trees, graphs, and more
- **Algorithm Practice**: Sorting, searching, traversals, and graph algorithms  
- **Automated Testing**: JUnit tests verify your implementations
- **Progress Tracking**: Statistics track how many times you've practiced each algorithm

## Requirements

- Java 11 or higher
- Maven 3.6 or higher

## Quick Start

1. **Clone and Setup**
   ```bash
   cd kata-machine-java
   mvn compile
   ```

2. **Generate Your First Day**
   ```bash
   ./generate.sh
   ```
   This creates `src/main/java/com/kata/day1/` with skeleton implementations.

3. **Run Tests**
   ```bash
   mvn test          # Run all tests
   ./test.sh Linear  # Run specific tests by pattern (like npx jest Linear)
   ./test.sh         # Run all tests (same as mvn test)
   ```

4. **Implement Algorithms**
   - Open the generated files in `src/main/java/com/kata/day1/`
   - Implement the empty methods
   - Run tests to verify your solutions

5. **Generate Next Day**
   ```bash
   ./generate.sh
   ```
   Creates `day2` with fresh blank implementations for more practice.

## Configuration

Edit `kata.config.json` to choose which algorithms to practice:

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
- `ArrayList` - Dynamic array implementation
- `SinglyLinkedList` - Singly linked list
- `DoublyLinkedList` - Doubly linked list  
- `Queue` - FIFO queue
- `Stack` - LIFO stack
- `MinHeap` - Min heap implementation
- `Trie` - Prefix tree
- `Map` - Hash map implementation
- `LRU` - LRU cache

### Algorithms
- `BubbleSort` - Bubble sort algorithm
- `QuickSort` - Quick sort algorithm
- `BinarySearchList` - Binary search on sorted array
- `LinearSearchList` - Linear search
- `TwoCrystalBalls` - Two crystal balls problem
- `MazeSolver` - Maze solving algorithm

### Tree Operations
- `BTPreOrder` - Binary tree pre-order traversal
- `BTInOrder` - Binary tree in-order traversal  
- `BTPostOrder` - Binary tree post-order traversal
- `BTBFS` - Binary tree breadth-first search
- `CompareBinaryTrees` - Compare two binary trees
- `DFSOnBST` - Depth-first search on BST

### Graph Operations
- `DFSGraphList` - DFS on adjacency list graph
- `BFSGraphMatrix` - BFS on adjacency matrix graph

## Commands

```bash
# Generate new practice day
./generate.sh

# Run all tests
mvn test

# Run specific tests by pattern
./test.sh Linear     # Runs LinearSearchList test
./test.sh Binary     # Runs BinarySearchList test  
./test.sh List       # Runs ArrayList, SinglyLinkedList, DoublyLinkedList tests
./test.sh Stack      # Runs Stack test

# Clear all progress and start over
./clear.sh

# View practice statistics
cat stats.json
```

## How It Works

1. **Configuration**: `kata.config.json` specifies which algorithms to include
2. **Generation**: `./generate.sh` creates a new `dayN` folder with skeleton implementations
3. **Testing**: JUnit tests verify your implementations work correctly
4. **Progression**: Each generation creates a new day folder, preserving previous work
5. **Statistics**: `stats.json` tracks how many times you've practiced each algorithm

## Project Structure

```
kata-machine-java/
├── src/main/java/com/kata/
│   ├── types/           # Common data types (Point, BinaryNode, etc.)
│   ├── interfaces/      # Interfaces (List, etc.)
│   ├── day1/           # Generated practice files
│   ├── day2/           # Next practice session
│   └── ...
├── src/test/java/com/kata/  # Test files
├── kata.config.json    # Algorithm configuration
├── generate.sh         # Generation script
├── clear.sh           # Clear all progress
└── stats.json         # Practice statistics
```

## Tips

- Start with simpler algorithms like linear search and bubble sort
- Use the tests to understand the expected behavior
- Don't look at previous implementations when practicing
- Focus on understanding the algorithmic patterns
- Practice regularly to build muscle memory

## Original

This is a Java port of [ThePrimeagen's kata-machine](https://github.com/ThePrimeagen/kata-machine) TypeScript course.