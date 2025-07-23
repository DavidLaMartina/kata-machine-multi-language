from typing import Optional, List, TypeVar
from kata.types import *
from kata.interfaces import List as ListInterface

T = TypeVar('T')

class SinglyLinkedList(ListInterface[T]):
    def __init__(self):
        self.length: int = 0

    def prepend(self, item: T) -> None:
        pass

    def insert_at(self, item: T, idx: int) -> None:
        pass

    def append(self, item: T) -> None:
        pass

    def remove(self, item: T) -> Optional[T]:
        return None

    def get(self, idx: int) -> Optional[T]:
        return None

    def remove_at(self, idx: int) -> Optional[T]:
        return None

    def length(self) -> int:
        return 0
