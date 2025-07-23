package com.kata.types;

public class BinaryNode<T> {
    public T value;
    public BinaryNode<T> left;
    public BinaryNode<T> right;
    
    public BinaryNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}