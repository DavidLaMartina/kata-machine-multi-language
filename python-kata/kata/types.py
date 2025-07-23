from __future__ import annotations
from typing import TypeVar, Generic, Optional, List as PyList
from dataclasses import dataclass

T = TypeVar('T')

@dataclass
class Point:
    x: int
    y: int
    
    def __eq__(self, other):
        if not isinstance(other, Point):
            return False
        return self.x == other.x and self.y == other.y

@dataclass
class ListNode(Generic[T]):
    value: T
    next: Optional[ListNode[T]] = None
    prev: Optional[ListNode[T]] = None

@dataclass
class BinaryNode(Generic[T]):
    value: T
    left: Optional[BinaryNode[T]] = None
    right: Optional[BinaryNode[T]] = None

@dataclass
class GraphEdge:
    to: int
    weight: int

# Type aliases
WeightedAdjacencyList = PyList[PyList[GraphEdge]]
WeightedAdjacencyMatrix = PyList[PyList[int]]
AdjacencyList = PyList[PyList[int]]
AdjacencyMatrix = PyList[PyList[int]]