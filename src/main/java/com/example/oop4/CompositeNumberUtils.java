package com.example.oop4;

public interface CompositeNumberUtils<T extends CompositeNumber> {

    T sum(T first, T second);

    T subtract(T first, T second);

    T multiply(T first, T second);

    T multiplyByNumber(int first, T second);

    T division(T first, T second);

    double abs(T number);

    T[][] editValues(String[][] matrix);
}
