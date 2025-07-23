from typing import Optional, List, TypeVar
from kata.types import *
from kata.interfaces import List as ListInterface

K, V = TypeVar('K, V')

class Map:
    def __init__(self):
        pass

    def get(self, key: K) -> Optional[V]:
        return None

    def set(self, key: K, value: V) -> None:
        pass

    def delete(self, key: K) -> Optional[V]:
        return None

    def size(self) -> int:
        return 0
