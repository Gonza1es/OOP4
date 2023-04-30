package com.example.oop4;

public class RealNumberUtils implements CompositeNumberUtils<RealNumber>{
    @Override
    public RealNumber sum(RealNumber first, RealNumber second) {
        return new RealNumber(first.doubleFirstValue() + second.doubleFirstValue());
    }

    @Override
    public RealNumber subtract(RealNumber first, RealNumber second) {
        return new RealNumber(first.doubleFirstValue() - second.doubleFirstValue());
    }

    @Override
    public RealNumber multiply(RealNumber first, RealNumber second) {
        return new RealNumber(first.doubleFirstValue() * second.doubleFirstValue());
    }

    @Override
    public RealNumber multiplyByNumber(int first, RealNumber second) {
        return new RealNumber(first * second.doubleFirstValue());
    }

    @Override
    public RealNumber division(RealNumber first, RealNumber second) {
        return new RealNumber(first.doubleFirstValue() / second.doubleFirstValue());
    }

    @Override
    public double abs(RealNumber number) {
        return Math.abs(number.doubleFirstValue());
    }

    @Override
    public RealNumber[][] editValues(String[][] matrix) {
        RealNumber[][] newMatrix = new RealNumber[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                try {
                    newMatrix[i][j] = new RealNumber(matrix[i][j]);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return newMatrix;
    }
}
