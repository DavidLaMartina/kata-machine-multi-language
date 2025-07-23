from typing import Optional, List, TypeVar
from kata.types import *
from kata.interfaces import List as ListInterface

T = TypeVar('T')

class Queue:
    def __init__(self):
        self.length: int = 0

    def enqueue(self, item: T) -> None:
        pass

    def deque(self) -> Optional[T]:
        return None

    def peek(self) -> Optional[T]:
        return None
