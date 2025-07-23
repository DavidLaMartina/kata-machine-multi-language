import pytest
import importlib
import os
from pathlib import Path
from kata.types import BinaryNode, Point
from test_list import test_list

def get_current_day():
    """Get the current day from the highest numbered day directory."""
    kata_dir = Path("kata")
    if not kata_dir.exists():
        return "day1"
    
    day_numbers = []
    for item in kata_dir.iterdir():
        if item.is_dir() and item.name.startswith("day"):
            try:
                day_num = int(item.name[3:])
                day_numbers.append(day_num)
            except ValueError:
                continue
    
    if not day_numbers:
        return "day1"
    
    return f"day{max(day_numbers)}"

def test_array_list():
    current_day = get_current_day()
    module_name = f"kata.{current_day}.ArrayList"
    module = importlib.import_module(module_name)
    
    lst = module.ArrayList()
    test_list(lst)

def test_singly_linked_list():
    current_day = get_current_day()
    module_name = f"kata.{current_day}.SinglyLinkedList"
    module = importlib.import_module(module_name)
    
    lst = module.SinglyLinkedList()
    test_list(lst)

def test_doubly_linked_list():
    current_day = get_current_day()
    module_name = f"kata.{current_day}.DoublyLinkedList"
    module = importlib.import_module(module_name)
    
    lst = module.DoublyLinkedList()
    test_list(lst)

def test_queue():
    current_day = get_current_day()
    module_name = f"kata.{current_day}.Queue"
    module = importlib.import_module(module_name)
    
    queue = module.Queue()
    
    queue.enqueue(5)
    queue.enqueue(7)
    queue.enqueue(9)
    
    assert queue.peek() == 5
    assert queue.deque() == 5
    assert queue.deque() == 7
    assert queue.peek() == 9
    assert queue.deque() == 9

def test_stack():
    current_day = get_current_day()
    module_name = f"kata.{current_day}.Stack"
    module = importlib.import_module(module_name)
    
    stack = module.Stack()
    
    stack.push(5)
    stack.push(7)
    stack.push(9)
    
    assert stack.peek() == 9
    assert stack.pop() == 9
    assert stack.pop() == 7
    assert stack.peek() == 5
    assert stack.pop() == 5

def test_linear_search():
    current_day = get_current_day()
    module_name = f"kata.{current_day}.LinearSearchList"
    module = importlib.import_module(module_name)
    
    arr = [1, 3, 4, 69, 71, 81, 90, 99, 420, 1337, 69420]
    
    assert module.linear_search(arr, 69) == True
    assert module.linear_search(arr, 1336) == False
    assert module.linear_search(arr, 69420) == True
    assert module.linear_search(arr, 69421) == False
    assert module.linear_search(arr, 1) == True
    assert module.linear_search(arr, 0) == False

def test_binary_search():
    current_day = get_current_day()
    module_name = f"kata.{current_day}.BinarySearchList"
    module = importlib.import_module(module_name)
    
    arr = [1, 3, 4, 69, 71, 81, 90, 99, 420, 1337, 69420]
    
    assert module.binary_search(arr, 69) == True
    assert module.binary_search(arr, 1336) == False
    assert module.binary_search(arr, 69420) == True
    assert module.binary_search(arr, 69421) == False
    assert module.binary_search(arr, 1) == True
    assert module.binary_search(arr, 0) == False

def test_two_crystal_balls():
    current_day = get_current_day()
    module_name = f"kata.{current_day}.TwoCrystalBalls"
    module = importlib.import_module(module_name)
    
    idx = 25
    data = [False] * 100
    for i in range(idx, 100):
        data[i] = True
    
    assert module.two_crystal_balls(data) == idx
    assert module.two_crystal_balls([False] * 821) == -1

def test_bubble_sort():
    current_day = get_current_day()
    module_name = f"kata.{current_day}.BubbleSort"
    module = importlib.import_module(module_name)
    
    arr = [9, 3, 7, 4, 69, 420, 42]
    module.bubble_sort(arr)
    
    expected = [3, 4, 7, 9, 42, 69, 420]
    assert arr == expected