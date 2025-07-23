from kata.interfaces import List

def test_list(lst: List[int]) -> None:
    """Test function for list implementations."""
    lst.append(5)
    lst.append(7)
    lst.append(9)

    assert lst.get(2) == 9
    assert lst.remove_at(1) == 7
    assert lst.length == 2

    lst.append(11)
    assert lst.remove_at(1) == 9
    assert lst.remove(9) is None
    assert lst.remove_at(0) == 5
    assert lst.remove_at(0) == 11
    assert lst.length == 0

    lst.prepend(5)
    lst.prepend(7)
    lst.prepend(9)

    assert lst.get(2) == 5
    assert lst.get(0) == 9
    assert lst.remove(9) == 9
    assert lst.length == 2
    assert lst.get(0) == 7