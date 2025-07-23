package com.kata;

import java.util.*;

public class AlgorithmDefinitions {
    
    public static class Method {
        public String name;
        public String parameters;
        public String returnType;
        
        public Method(String name, String parameters, String returnType) {
            this.name = name;
            this.parameters = parameters;
            this.returnType = returnType;
        }
    }
    
    public static class Property {
        public String name;
        public String type;
        public String scope;
        
        public Property(String name, String type, String scope) {
            this.name = name;
            this.type = type;
            this.scope = scope;
        }
    }
    
    public static class AlgorithmDef {
        public String type; // "class" or "function"
        public String generic;
        public String functionName;
        public String parameters;
        public String returnType;
        public List<Method> methods;
        public List<Property> properties;
        
        public AlgorithmDef(String type) {
            this.type = type;
            this.methods = new ArrayList<>();
            this.properties = new ArrayList<>();
        }
    }
    
    private static final List<Property> LENGTH_PROPERTY = Arrays.asList(
        new Property("length", "int", "public")
    );
    
    private static final List<Method> LIST_INTERFACE_METHODS = Arrays.asList(
        new Method("prepend", "T item", "void"),
        new Method("insertAt", "T item, int idx", "void"),
        new Method("append", "T item", "void"),
        new Method("remove", "T item", "T"),
        new Method("get", "int idx", "T"),
        new Method("removeAt", "int idx", "T"),
        new Method("getLength", "", "int")
    );
    
    public static Map<String, AlgorithmDef> getDefinitions() {
        Map<String, AlgorithmDef> defs = new HashMap<>();
        
        // LRU Cache
        AlgorithmDef lru = new AlgorithmDef("class");
        lru.generic = "<K, V>";
        lru.methods.add(new Method("update", "K key, V value", "void"));
        lru.methods.add(new Method("get", "K key", "V"));
        lru.properties.add(new Property("length", "int", "private"));
        defs.put("LRU", lru);
        
        // MinHeap
        AlgorithmDef minHeap = new AlgorithmDef("class");
        minHeap.methods.add(new Method("insert", "int value", "void"));
        minHeap.methods.add(new Method("delete", "", "Integer"));
        minHeap.properties.addAll(LENGTH_PROPERTY);
        defs.put("MinHeap", minHeap);
        
        // Map
        AlgorithmDef map = new AlgorithmDef("class");
        map.generic = "<K, V>";
        map.methods.add(new Method("get", "K key", "V"));
        map.methods.add(new Method("set", "K key, V value", "void"));
        map.methods.add(new Method("delete", "K key", "V"));
        map.methods.add(new Method("size", "", "Integer"));
        defs.put("Map", map);
        
        // ArrayList
        AlgorithmDef arrayList = new AlgorithmDef("class");
        arrayList.generic = "<T>";
        arrayList.methods.addAll(LIST_INTERFACE_METHODS);
        arrayList.properties.addAll(LENGTH_PROPERTY);
        defs.put("ArrayList", arrayList);
        
        // SinglyLinkedList
        AlgorithmDef singlyLinkedList = new AlgorithmDef("class");
        singlyLinkedList.generic = "<T>";
        singlyLinkedList.methods.addAll(LIST_INTERFACE_METHODS);
        singlyLinkedList.properties.addAll(LENGTH_PROPERTY);
        defs.put("SinglyLinkedList", singlyLinkedList);
        
        // DoublyLinkedList
        AlgorithmDef doublyLinkedList = new AlgorithmDef("class");
        doublyLinkedList.generic = "<T>";
        doublyLinkedList.methods.addAll(LIST_INTERFACE_METHODS);
        doublyLinkedList.properties.addAll(LENGTH_PROPERTY);
        defs.put("DoublyLinkedList", doublyLinkedList);
        
        // Queue
        AlgorithmDef queue = new AlgorithmDef("class");
        queue.generic = "<T>";
        queue.properties.addAll(LENGTH_PROPERTY);
        queue.methods.add(new Method("enqueue", "T item", "void"));
        queue.methods.add(new Method("deque", "", "T"));
        queue.methods.add(new Method("peek", "", "T"));
        defs.put("Queue", queue);
        
        // Stack
        AlgorithmDef stack = new AlgorithmDef("class");
        stack.generic = "<T>";
        stack.properties.addAll(LENGTH_PROPERTY);
        stack.methods.add(new Method("push", "T item", "void"));
        stack.methods.add(new Method("pop", "", "T"));
        stack.methods.add(new Method("peek", "", "T"));
        defs.put("Stack", stack);
        
        // Trie
        AlgorithmDef trie = new AlgorithmDef("class");
        trie.methods.add(new Method("insert", "String item", "void"));
        trie.methods.add(new Method("delete", "String item", "void"));
        trie.methods.add(new Method("find", "String partial", "String[]"));
        defs.put("Trie", trie);
        
        // Function-based algorithms
        AlgorithmDef bubbleSort = new AlgorithmDef("function");
        bubbleSort.functionName = "bubbleSort";
        bubbleSort.parameters = "int[] arr";
        bubbleSort.returnType = "void";
        defs.put("BubbleSort", bubbleSort);
        
        AlgorithmDef quickSort = new AlgorithmDef("function");
        quickSort.functionName = "quickSort";
        quickSort.parameters = "int[] arr";
        quickSort.returnType = "void";
        defs.put("QuickSort", quickSort);
        
        AlgorithmDef binarySearchList = new AlgorithmDef("function");
        binarySearchList.functionName = "binarySearch";
        binarySearchList.parameters = "int[] haystack, int needle";
        binarySearchList.returnType = "boolean";
        defs.put("BinarySearchList", binarySearchList);
        
        AlgorithmDef linearSearchList = new AlgorithmDef("function");
        linearSearchList.functionName = "linearSearch";
        linearSearchList.parameters = "int[] haystack, int needle";
        linearSearchList.returnType = "boolean";
        defs.put("LinearSearchList", linearSearchList);
        
        AlgorithmDef twoCrystalBalls = new AlgorithmDef("function");
        twoCrystalBalls.functionName = "twoCrystalBalls";
        twoCrystalBalls.parameters = "boolean[] breaks";
        twoCrystalBalls.returnType = "Integer";
        defs.put("TwoCrystalBalls", twoCrystalBalls);
        
        AlgorithmDef mazeSolver = new AlgorithmDef("function");
        mazeSolver.functionName = "solve";
        mazeSolver.parameters = "String[] maze, String wall, Point start, Point end";
        mazeSolver.returnType = "Point[]";
        defs.put("MazeSolver", mazeSolver);
        
        AlgorithmDef btPreOrder = new AlgorithmDef("function");
        btPreOrder.functionName = "preOrderSearch";
        btPreOrder.parameters = "BinaryNode<Integer> head";
        btPreOrder.returnType = "Integer[]";
        defs.put("BTPreOrder", btPreOrder);
        
        AlgorithmDef btInOrder = new AlgorithmDef("function");
        btInOrder.functionName = "inOrderSearch";
        btInOrder.parameters = "BinaryNode<Integer> head";
        btInOrder.returnType = "Integer[]";
        defs.put("BTInOrder", btInOrder);
        
        AlgorithmDef btPostOrder = new AlgorithmDef("function");
        btPostOrder.functionName = "postOrderSearch";
        btPostOrder.parameters = "BinaryNode<Integer> head";
        btPostOrder.returnType = "Integer[]";
        defs.put("BTPostOrder", btPostOrder);
        
        AlgorithmDef btbfs = new AlgorithmDef("function");
        btbfs.functionName = "bfs";
        btbfs.parameters = "BinaryNode<Integer> head, int needle";
        btbfs.returnType = "boolean";
        defs.put("BTBFS", btbfs);
        
        AlgorithmDef compareBinaryTrees = new AlgorithmDef("function");
        compareBinaryTrees.functionName = "compare";
        compareBinaryTrees.parameters = "BinaryNode<Integer> a, BinaryNode<Integer> b";
        compareBinaryTrees.returnType = "boolean";
        defs.put("CompareBinaryTrees", compareBinaryTrees);
        
        AlgorithmDef dfsOnBST = new AlgorithmDef("function");
        dfsOnBST.functionName = "dfs";
        dfsOnBST.parameters = "BinaryNode<Integer> head, int needle";
        dfsOnBST.returnType = "boolean";
        defs.put("DFSOnBST", dfsOnBST);
        
        AlgorithmDef dfsGraphList = new AlgorithmDef("function");
        dfsGraphList.functionName = "dfs";
        dfsGraphList.parameters = "List<List<GraphEdge>> graph, int source, int needle";
        dfsGraphList.returnType = "Integer[]";
        defs.put("DFSGraphList", dfsGraphList);
        
        AlgorithmDef bfsGraphMatrix = new AlgorithmDef("function");
        bfsGraphMatrix.functionName = "bfs";
        bfsGraphMatrix.parameters = "int[][] graph, int source, int needle";
        bfsGraphMatrix.returnType = "Integer[]";
        defs.put("BFSGraphMatrix", bfsGraphMatrix);
        
        return defs;
    }
}