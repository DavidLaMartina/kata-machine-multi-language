from typing import Optional, List, TypeVar
from kata.types import *
from kata.interfaces import List as ListInterface

T = TypeVar('T')

class Stack:
    def __init__(self):
        self.length: int = 0

    def push(self, item: T) -> None:
        pass

    def pop(self) -> Optional[T]:
        return None

    def peek(self) -> Optional[T]:
        return None
