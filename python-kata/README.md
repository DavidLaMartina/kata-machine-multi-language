# Kata Machine Python

A Python implementation of the kata-machine leetcode-style problem solving course. This provides the same "day" generation system that allows you to practice data structures and algorithms with a clean slate each time.

## Features

- **Day Generation**: Create new practice sessions with blank implementations
- **Multiple Data Structures**: Lists, stacks, queues, trees, graphs, and more
- **Algorithm Practice**: Sorting, searching, traversals, and graph algorithms  
- **Automated Testing**: pytest tests verify your implementations
- **Progress Tracking**: Statistics track how many times you've practiced each algorithm

## Requirements

- Python 3.8 or higher
- pip (Python package manager)

## Quick Start

1. **Setup**
   ```bash
   cd python-kata
   ./setup.sh                # Creates virtual env and installs dependencies
   source venv/bin/activate  # Activate virtual environment (do this each time)
   ```

2. **Generate Your First Day**
   ```bash
   ./generate.sh
   ```
   This creates `kata/day1/` with skeleton implementations.

3. **Run Tests**
   ```bash
   pytest                # Run all tests
   ./test.sh linear      # Run specific tests by pattern (like npx jest Linear)
   ./test.sh             # Run all tests (same as pytest)
   ```

4. **Implement Algorithms**
   - Open the generated files in `kata/day1/`
   - Implement the empty functions/methods
   - Run tests to verify your solutions

5. **Generate Next Day**
   ```bash
   ./generate.sh
   ```
   Creates `day2` with fresh blank implementations for more practice.

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
pytest

# Run specific tests by pattern
./test.sh linear     # Runs linear_search test
./test.sh binary     # Runs binary_search test  
./test.sh list       # Runs ArrayList, SinglyLinkedList, DoublyLinkedList tests
./test.sh stack      # Runs Stack test

# Clear all progress and start over
./clear.sh

# View practice statistics
cat stats.json
```

## How It Works

1. **Configuration**: `kata_config.json` specifies which algorithms to include
2. **Generation**: `./generate.sh` creates a new `dayN` folder with skeleton implementations
3. **Testing**: pytest tests verify your implementations work correctly
4. **Progression**: Each generation creates a new day folder, preserving previous work
5. **Statistics**: `stats.json` tracks how many times you've practiced each algorithm

## Project Structure

```
python-kata/
├── kata/
│   ├── types.py         # Common data types (Point, BinaryNode, etc.)
│   ├── interfaces.py    # Interfaces (List, etc.)
│   ├── day1/           # Generated practice files
│   ├── day2/           # Next practice session
│   └── ...
├── test_algorithms.py  # Test file
├── test_list.py       # List testing utilities
├── kata_config.json   # Algorithm configuration
├── generator.py       # Generation script
├── generate.sh        # Generation wrapper
├── clear.sh          # Clear all progress
└── stats.json        # Practice statistics
```

## Python-Specific Features

- **Type Hints**: Full type annotation support for better IDE experience
- **Dataclasses**: Clean, modern Python data structures
- **Generic Types**: Proper generic type support for containers
- **Optional Types**: Explicit handling of nullable return values
- **pytest**: Modern Python testing framework with excellent output

## Tips

- Start with simpler algorithms like linear search and bubble sort
- Use the tests to understand the expected behavior
- Don't look at previous implementations when practicing
- Focus on understanding the algorithmic patterns
- Python's dynamic nature makes some algorithms easier to implement

## Original

This is a Python port of [ThePrimeagen's kata-machine](https://github.com/ThePrimeagen/kata-machine) TypeScript course.