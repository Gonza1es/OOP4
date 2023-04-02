package com.example.oop4;

public interface CompositeNumberUtils {

    CompositeNumber sum(CompositeNumber first, CompositeNumber second);

    CompositeNumber subtract(CompositeNumber first, CompositeNumber second);

    CompositeNumber multiply(CompositeNumber first, CompositeNumber second);

    CompositeNumber multiplyByNumber(int first, CompositeNumber second);

    CompositeNumber division(CompositeNumber first, CompositeNumber second);

    double abs(CompositeNumber number);

    CompositeNumber[][] editValues(String[][] matrix);
}
