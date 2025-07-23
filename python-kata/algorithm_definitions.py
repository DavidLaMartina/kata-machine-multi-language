from dataclasses import dataclass
from typing import List, Dict, Optional

@dataclass
class Method:
    name: str
    parameters: str
    return_type: str

@dataclass
class Property:
    name: str
    type: str
    scope: str

@dataclass
class AlgorithmDef:
    type: str  # "class" or "function"
    generic: Optional[str] = None
    function_name: Optional[str] = None
    parameters: Optional[str] = None
    return_type: Optional[str] = None
    methods: List[Method] = None
    properties: List[Property] = None
    
    def __post_init__(self):
        if self.methods is None:
            self.methods = []
        if self.properties is None:
            self.properties = []

# Common patterns
def length_property():
    return [Property("length", "int", "public")]

def list_interface_methods():
    return [
        Method("prepend", "item: T", "None"),
        Method("insert_at", "item: T, idx: int", "None"),
        Method("append", "item: T", "None"),
        Method("remove", "item: T", "Optional[T]"),
        Method("get", "idx: int", "Optional[T]"),
        Method("remove_at", "idx: int", "Optional[T]"),
        Method("length", "", "int")
    ]

def get_definitions() -> Dict[str, AlgorithmDef]:
    defs = {}
    
    # LRU Cache
    lru = AlgorithmDef("class", "[K, V]")
    lru.methods = [
        Method("update", "key: K, value: V", "None"),
        Method("get", "key: K", "Optional[V]")
    ]
    lru.properties = [Property("length", "int", "private")]
    defs["LRU"] = lru
    
    # MinHeap
    min_heap = AlgorithmDef("class")
    min_heap.methods = [
        Method("insert", "value: int", "None"),
        Method("delete", "", "Optional[int]")
    ]
    min_heap.properties = length_property()
    defs["MinHeap"] = min_heap
    
    # Map
    hash_map = AlgorithmDef("class", "[K, V]")
    hash_map.methods = [
        Method("get", "key: K", "Optional[V]"),
        Method("set", "key: K, value: V", "None"),
        Method("delete", "key: K", "Optional[V]"),
        Method("size", "", "int")
    ]
    defs["Map"] = hash_map
    
    # ArrayList
    array_list = AlgorithmDef("class", "[T]")
    array_list.methods = list_interface_methods()
    array_list.properties = length_property()
    defs["ArrayList"] = array_list
    
    # SinglyLinkedList
    singly_linked_list = AlgorithmDef("class", "[T]")
    singly_linked_list.methods = list_interface_methods()
    singly_linked_list.properties = length_property()
    defs["SinglyLinkedList"] = singly_linked_list
    
    # DoublyLinkedList
    doubly_linked_list = AlgorithmDef("class", "[T]")
    doubly_linked_list.methods = list_interface_methods()
    doubly_linked_list.properties = length_property()
    defs["DoublyLinkedList"] = doubly_linked_list
    
    # Queue
    queue = AlgorithmDef("class", "[T]")
    queue.properties = length_property()
    queue.methods = [
        Method("enqueue", "item: T", "None"),
        Method("deque", "", "Optional[T]"),
        Method("peek", "", "Optional[T]")
    ]
    defs["Queue"] = queue
    
    # Stack
    stack = AlgorithmDef("class", "[T]")
    stack.properties = length_property()
    stack.methods = [
        Method("push", "item: T", "None"),
        Method("pop", "", "Optional[T]"),
        Method("peek", "", "Optional[T]")
    ]
    defs["Stack"] = stack
    
    # Trie
    trie = AlgorithmDef("class")
    trie.methods = [
        Method("insert", "item: str", "None"),
        Method("delete", "item: str", "None"),
        Method("find", "partial: str", "List[str]")
    ]
    defs["Trie"] = trie
    
    # Function-based algorithms
    bubble_sort = AlgorithmDef("function")
    bubble_sort.function_name = "bubble_sort"
    bubble_sort.parameters = "arr: List[int]"
    bubble_sort.return_type = "None"
    defs["BubbleSort"] = bubble_sort
    
    quick_sort = AlgorithmDef("function")
    quick_sort.function_name = "quick_sort"
    quick_sort.parameters = "arr: List[int]"
    quick_sort.return_type = "None"
    defs["QuickSort"] = quick_sort
    
    binary_search_list = AlgorithmDef("function")
    binary_search_list.function_name = "binary_search"
    binary_search_list.parameters = "haystack: List[int], needle: int"
    binary_search_list.return_type = "bool"
    defs["BinarySearchList"] = binary_search_list
    
    linear_search_list = AlgorithmDef("function")
    linear_search_list.function_name = "linear_search"
    linear_search_list.parameters = "haystack: List[int], needle: int"
    linear_search_list.return_type = "bool"
    defs["LinearSearchList"] = linear_search_list
    
    two_crystal_balls = AlgorithmDef("function")
    two_crystal_balls.function_name = "two_crystal_balls"
    two_crystal_balls.parameters = "breaks: List[bool]"
    two_crystal_balls.return_type = "int"
    defs["TwoCrystalBalls"] = two_crystal_balls
    
    maze_solver = AlgorithmDef("function")
    maze_solver.function_name = "solve"
    maze_solver.parameters = "maze: List[str], wall: str, start: Point, end: Point"
    maze_solver.return_type = "List[Point]"
    defs["MazeSolver"] = maze_solver
    
    bt_pre_order = AlgorithmDef("function")
    bt_pre_order.function_name = "pre_order_search"
    bt_pre_order.parameters = "head: Optional[BinaryNode[int]]"
    bt_pre_order.return_type = "List[int]"
    defs["BTPreOrder"] = bt_pre_order
    
    bt_in_order = AlgorithmDef("function")
    bt_in_order.function_name = "in_order_search"
    bt_in_order.parameters = "head: Optional[BinaryNode[int]]"
    bt_in_order.return_type = "List[int]"
    defs["BTInOrder"] = bt_in_order
    
    bt_post_order = AlgorithmDef("function")
    bt_post_order.function_name = "post_order_search"
    bt_post_order.parameters = "head: Optional[BinaryNode[int]]"
    bt_post_order.return_type = "List[int]"
    defs["BTPostOrder"] = bt_post_order
    
    btbfs = AlgorithmDef("function")
    btbfs.function_name = "bfs"
    btbfs.parameters = "head: Optional[BinaryNode[int]], needle: int"
    btbfs.return_type = "bool"
    defs["BTBFS"] = btbfs
    
    compare_binary_trees = AlgorithmDef("function")
    compare_binary_trees.function_name = "compare"
    compare_binary_trees.parameters = "a: Optional[BinaryNode[int]], b: Optional[BinaryNode[int]]"
    compare_binary_trees.return_type = "bool"
    defs["CompareBinaryTrees"] = compare_binary_trees
    
    dfs_on_bst = AlgorithmDef("function")
    dfs_on_bst.function_name = "dfs"
    dfs_on_bst.parameters = "head: Optional[BinaryNode[int]], needle: int"
    dfs_on_bst.return_type = "bool"
    defs["DFSOnBST"] = dfs_on_bst
    
    dfs_graph_list = AlgorithmDef("function")
    dfs_graph_list.function_name = "dfs"
    dfs_graph_list.parameters = "graph: WeightedAdjacencyList, source: int, needle: int"
    dfs_graph_list.return_type = "Optional[List[int]]"
    defs["DFSGraphList"] = dfs_graph_list
    
    bfs_graph_matrix = AlgorithmDef("function")
    bfs_graph_matrix.function_name = "bfs"
    bfs_graph_matrix.parameters = "graph: WeightedAdjacencyMatrix, source: int, needle: int"
    bfs_graph_matrix.return_type = "Optional[List[int]]"
    defs["BFSGraphMatrix"] = bfs_graph_matrix
    
    return defs