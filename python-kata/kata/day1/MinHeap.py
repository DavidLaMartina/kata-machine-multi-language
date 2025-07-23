from typing import Optional, List, TypeVar
from kata.types import *
from kata.interfaces import List as ListInterface

class MinHeap:
    def __init__(self):
        self.length: int = 0

    def insert(self, value: int) -> None:
        pass

    def delete(self) -> Optional[int]:
        return None
