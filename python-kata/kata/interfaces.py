from abc import ABC, abstractmethod
from typing import TypeVar, Generic, Optional

T = TypeVar('T')

class List(ABC, Generic[T]):
    @property
    @abstractmethod
    def length(self) -> int:
        pass
    
    @abstractmethod
    def remove_at(self, index: int) -> Optional[T]:
        pass
    
    @abstractmethod
    def remove(self, item: T) -> Optional[T]:
        pass
    
    @abstractmethod
    def get(self, index: int) -> Optional[T]:
        pass
    
    @abstractmethod
    def prepend(self, item: T) -> None:
        pass
    
    @abstractmethod
    def append(self, item: T) -> None:
        pass
    
    @abstractmethod
    def insert_at(self, item: T, idx: int) -> None:
        pass