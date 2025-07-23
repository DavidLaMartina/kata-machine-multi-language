from typing import Optional, List, TypeVar
from kata.types import *
from kata.interfaces import List as ListInterface

K, V = TypeVar('K, V')

class LRU:
    def __init__(self):
        self.length: int = 0

    def update(self, key: K, value: V) -> None:
        pass

    def get(self, key: K) -> Optional[V]:
        return None
