package com.kata.interfaces;

public interface List<T> {
    int getLength();
    T removeAt(int index);
    T remove(T item);
    T get(int index);
    void prepend(T item);
    void append(T item);
    void insertAt(T item, int idx);
}