package com.example.oop4;

public class MatrixFactory {

    public static MatrixUtils getMatrix(String input, CompositeNumberUtils utils) {
        String[] rows = input.split("\n");
        String[] column = rows[0].split(" ");
        if (rows.length == column.length) {
            return new SquareMatrix(input, utils);
        } else {
            return new Matrix(input, utils);
        }
    }
}
