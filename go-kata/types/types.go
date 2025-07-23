package types

// Point represents a 2D coordinate point
type Point struct {
	X int
	Y int
}

// ListNode represents a node in a linked list
type ListNode[T any] struct {
	Value T
	Next  *ListNode[T]
	Prev  *ListNode[T]
}

// BinaryNode represents a node in a binary tree
type BinaryNode[T any] struct {
	Value T
	Left  *BinaryNode[T]
	Right *BinaryNode[T]
}

// GraphEdge represents a weighted edge in a graph
type GraphEdge struct {
	To     int
	Weight int
}

// Type aliases for graph representations
type WeightedAdjacencyList = [][]GraphEdge
type WeightedAdjacencyMatrix = [][]int
type AdjacencyList = [][]int
type AdjacencyMatrix = [][]int