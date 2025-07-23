package main

import (
	"fmt"
	"os"
	"path/filepath"
	"strings"
)

type Method struct {
	Name       string `json:"name"`
	Parameters string `json:"parameters"`
	ReturnType string `json:"return_type"`
	Receiver   string `json:"receiver,omitempty"`
}

type Property struct {
	Name string `json:"name"`
	Type string `json:"type"`
}

type AlgorithmDef struct {
	Type         string     `json:"type"` // "struct", "interface", or "function"
	Generic      string     `json:"generic,omitempty"`
	FunctionName string     `json:"function_name,omitempty"`
	Parameters   string     `json:"parameters,omitempty"`
	ReturnType   string     `json:"return_type,omitempty"`
	Methods      []Method   `json:"methods,omitempty"`
	Properties   []Property `json:"properties,omitempty"`
}

func getLengthProperty() []Property {
	return []Property{
		{Name: "length", Type: "int"},
	}
}

func getListInterfaceMethods() []Method {
	return []Method{
		{Name: "Prepend", Parameters: "item T", ReturnType: "", Receiver: "l *%s[T]"},
		{Name: "InsertAt", Parameters: "item T, idx int", ReturnType: "", Receiver: "l *%s[T]"},
		{Name: "Append", Parameters: "item T", ReturnType: "", Receiver: "l *%s[T]"},
		{Name: "Remove", Parameters: "item T", ReturnType: "*T", Receiver: "l *%s[T]"},
		{Name: "Get", Parameters: "idx int", ReturnType: "*T", Receiver: "l *%s[T]"},
		{Name: "RemoveAt", Parameters: "idx int", ReturnType: "*T", Receiver: "l *%s[T]"},
		{Name: "Length", Parameters: "", ReturnType: "int", Receiver: "l *%s[T]"},
	}
}

func getDefinitions() map[string]AlgorithmDef {
	defs := make(map[string]AlgorithmDef)

	// LRU Cache
	defs["LRU"] = AlgorithmDef{
		Type:    "struct",
		Generic: "[K comparable, V any]",
		Properties: []Property{
			{Name: "length", Type: "int"},
		},
		Methods: []Method{
			{Name: "Update", Parameters: "key K, value V", ReturnType: "", Receiver: "l *LRU[K, V]"},
			{Name: "Get", Parameters: "key K", ReturnType: "*V", Receiver: "l *LRU[K, V]"},
		},
	}

	// MinHeap
	defs["MinHeap"] = AlgorithmDef{
		Type:       "struct",
		Properties: getLengthProperty(),
		Methods: []Method{
			{Name: "Insert", Parameters: "value int", ReturnType: "", Receiver: "h *MinHeap"},
			{Name: "Delete", Parameters: "", ReturnType: "*int", Receiver: "h *MinHeap"},
		},
	}

	// Map
	defs["Map"] = AlgorithmDef{
		Type:    "struct",
		Generic: "[K comparable, V any]",
		Methods: []Method{
			{Name: "Get", Parameters: "key K", ReturnType: "*V", Receiver: "m *Map[K, V]"},
			{Name: "Set", Parameters: "key K, value V", ReturnType: "", Receiver: "m *Map[K, V]"},
			{Name: "Delete", Parameters: "key K", ReturnType: "*V", Receiver: "m *Map[K, V]"},
			{Name: "Size", Parameters: "", ReturnType: "int", Receiver: "m *Map[K, V]"},
		},
	}

	// ArrayList
	arrayList := AlgorithmDef{
		Type:       "struct",
		Generic:    "[T any]",
		Properties: getLengthProperty(),
		Methods:    getListInterfaceMethods(),
	}
	defs["ArrayList"] = arrayList

	// SinglyLinkedList
	singlyLinkedList := AlgorithmDef{
		Type:       "struct",
		Generic:    "[T any]",
		Properties: getLengthProperty(),
		Methods:    getListInterfaceMethods(),
	}
	defs["SinglyLinkedList"] = singlyLinkedList

	// DoublyLinkedList
	doublyLinkedList := AlgorithmDef{
		Type:       "struct",
		Generic:    "[T any]",
		Properties: getLengthProperty(),
		Methods:    getListInterfaceMethods(),
	}
	defs["DoublyLinkedList"] = doublyLinkedList

	// Queue
	defs["Queue"] = AlgorithmDef{
		Type:       "struct",
		Generic:    "[T any]",
		Properties: getLengthProperty(),
		Methods: []Method{
			{Name: "Enqueue", Parameters: "item T", ReturnType: "", Receiver: "q *Queue[T]"},
			{Name: "Deque", Parameters: "", ReturnType: "*T", Receiver: "q *Queue[T]"},
			{Name: "Peek", Parameters: "", ReturnType: "*T", Receiver: "q *Queue[T]"},
		},
	}

	// Stack
	defs["Stack"] = AlgorithmDef{
		Type:       "struct",
		Generic:    "[T any]",
		Properties: getLengthProperty(),
		Methods: []Method{
			{Name: "Push", Parameters: "item T", ReturnType: "", Receiver: "s *Stack[T]"},
			{Name: "Pop", Parameters: "", ReturnType: "*T", Receiver: "s *Stack[T]"},
			{Name: "Peek", Parameters: "", ReturnType: "*T", Receiver: "s *Stack[T]"},
		},
	}

	// Trie
	defs["Trie"] = AlgorithmDef{
		Type: "struct",
		Methods: []Method{
			{Name: "Insert", Parameters: "item string", ReturnType: "", Receiver: "t *Trie"},
			{Name: "Delete", Parameters: "item string", ReturnType: "", Receiver: "t *Trie"},
			{Name: "Find", Parameters: "partial string", ReturnType: "[]string", Receiver: "t *Trie"},
		},
	}

	// Function-based algorithms
	defs["BubbleSort"] = AlgorithmDef{
		Type:         "function",
		FunctionName: "BubbleSort",
		Parameters:   "arr []int",
		ReturnType:   "",
	}

	defs["QuickSort"] = AlgorithmDef{
		Type:         "function",
		FunctionName: "QuickSort",
		Parameters:   "arr []int",
		ReturnType:   "",
	}

	defs["BinarySearchList"] = AlgorithmDef{
		Type:         "function",
		FunctionName: "BinarySearch",
		Parameters:   "haystack []int, needle int",
		ReturnType:   "bool",
	}

	defs["LinearSearchList"] = AlgorithmDef{
		Type:         "function",
		FunctionName: "LinearSearch",
		Parameters:   "haystack []int, needle int",
		ReturnType:   "bool",
	}

	defs["TwoCrystalBalls"] = AlgorithmDef{
		Type:         "function",
		FunctionName: "TwoCrystalBalls",
		Parameters:   "breaks []bool",
		ReturnType:   "int",
	}

	defs["MazeSolver"] = AlgorithmDef{
		Type:         "function",
		FunctionName: "Solve",
		Parameters:   "maze []string, wall string, start types.Point, end types.Point",
		ReturnType:   "[]types.Point",
	}

	defs["BTPreOrder"] = AlgorithmDef{
		Type:         "function",
		FunctionName: "PreOrderSearch",
		Parameters:   "head *types.BinaryNode[int]",
		ReturnType:   "[]int",
	}

	defs["BTInOrder"] = AlgorithmDef{
		Type:         "function",
		FunctionName: "InOrderSearch",
		Parameters:   "head *types.BinaryNode[int]",
		ReturnType:   "[]int",
	}

	defs["BTPostOrder"] = AlgorithmDef{
		Type:         "function",
		FunctionName: "PostOrderSearch",
		Parameters:   "head *types.BinaryNode[int]",
		ReturnType:   "[]int",
	}

	defs["BTBFS"] = AlgorithmDef{
		Type:         "function",
		FunctionName: "BFS",
		Parameters:   "head *types.BinaryNode[int], needle int",
		ReturnType:   "bool",
	}

	defs["CompareBinaryTrees"] = AlgorithmDef{
		Type:         "function",
		FunctionName: "Compare",
		Parameters:   "a *types.BinaryNode[int], b *types.BinaryNode[int]",
		ReturnType:   "bool",
	}

	defs["DFSOnBST"] = AlgorithmDef{
		Type:         "function",
		FunctionName: "DFS",
		Parameters:   "head *types.BinaryNode[int], needle int",
		ReturnType:   "bool",
	}

	defs["DFSGraphList"] = AlgorithmDef{
		Type:         "function",
		FunctionName: "DFS",
		Parameters:   "graph types.WeightedAdjacencyList, source int, needle int",
		ReturnType:   "[]int",
	}

	defs["BFSGraphMatrix"] = AlgorithmDef{
		Type:         "function",
		FunctionName: "BFS",
		Parameters:   "graph types.WeightedAdjacencyMatrix, source int, needle int",
		ReturnType:   "[]int",
	}

	return defs
}

func generateStruct(dayPath, structName string, def AlgorithmDef) error {
	var lines []string

	// Package declaration
	lines = append(lines, fmt.Sprintf("package %s", filepath.Base(dayPath)))
	lines = append(lines, "")

	// Imports
	lines = append(lines, "import (")
	lines = append(lines, "\t\"kata-machine/types\"")
	if strings.Contains(structName, "List") {
		lines = append(lines, "\t\"kata-machine/interfaces\"")
	}
	lines = append(lines, ")")
	lines = append(lines, "")

	// Struct definition
	structLine := fmt.Sprintf("type %s%s struct {", structName, def.Generic)
	lines = append(lines, structLine)

	// Properties
	for _, prop := range def.Properties {
		lines = append(lines, fmt.Sprintf("\t%s %s", strings.Title(prop.Name), prop.Type))
	}

	lines = append(lines, "}")
	lines = append(lines, "")

	// Methods
	for _, method := range def.Methods {
		receiver := method.Receiver
		if receiver == "" {
			receiver = fmt.Sprintf("s *%s%s", structName, def.Generic)
		} else {
			receiver = fmt.Sprintf(receiver, structName)
		}

		methodLine := fmt.Sprintf("func (%s) %s(%s)", receiver, method.Name, method.Parameters)
		if method.ReturnType != "" {
			methodLine += fmt.Sprintf(" %s", method.ReturnType)
		}
		methodLine += " {"
		lines = append(lines, methodLine)

		// Default return values
		if method.ReturnType != "" {
			if method.ReturnType == "bool" {
				lines = append(lines, "\treturn false")
			} else if method.ReturnType == "int" {
				lines = append(lines, "\treturn 0")
			} else if strings.HasPrefix(method.ReturnType, "[]") {
				lines = append(lines, "\treturn nil")
			} else {
				lines = append(lines, "\treturn nil")
			}
		}

		lines = append(lines, "}")
		lines = append(lines, "")
	}

	// Write file
	filePath := filepath.Join(dayPath, fmt.Sprintf("%s.go", structName))
	return os.WriteFile(filePath, []byte(strings.Join(lines, "\n")), 0644)
}

func generateFunction(dayPath, fileName string, def AlgorithmDef) error {
	var lines []string

	// Package declaration
	lines = append(lines, fmt.Sprintf("package %s", filepath.Base(dayPath)))
	lines = append(lines, "")

	// Imports
	lines = append(lines, "import (")
	lines = append(lines, "\t\"kata-machine/types\"")
	lines = append(lines, ")")
	lines = append(lines, "")

	// Function definition
	funcLine := fmt.Sprintf("func %s(%s)", def.FunctionName, def.Parameters)
	if def.ReturnType != "" {
		funcLine += fmt.Sprintf(" %s", def.ReturnType)
	}
	funcLine += " {"
	lines = append(lines, funcLine)

	// Default return values
	if def.ReturnType != "" {
		if def.ReturnType == "bool" {
			lines = append(lines, "\treturn false")
		} else if def.ReturnType == "int" {
			lines = append(lines, "\treturn -1")
		} else if strings.HasPrefix(def.ReturnType, "[]") {
			lines = append(lines, "\treturn nil")
		} else {
			lines = append(lines, "\treturn nil")
		}
	}

	lines = append(lines, "}")

	// Write file
	filePath := filepath.Join(dayPath, fmt.Sprintf("%s.go", fileName))
	return os.WriteFile(filePath, []byte(strings.Join(lines, "\n")), 0644)
}