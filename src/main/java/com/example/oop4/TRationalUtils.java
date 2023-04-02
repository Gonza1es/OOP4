package com.example.oop4;

public class TRationalUtils implements CompositeNumberUtils{

    @Override
    public CompositeNumber sum(CompositeNumber first, CompositeNumber second) {
        Integer resultA = first.intFirstValue() * second.intSecondValue() + second.intFirstValue() * first.intSecondValue();
        Integer resultB = first.intSecondValue() * second.intSecondValue();
        return new TRational(resultA, resultB);
    }

    @Override
    public CompositeNumber subtract(CompositeNumber first, CompositeNumber second) {
        Integer resultA = first.intFirstValue() * second.intSecondValue() - second.intFirstValue() * first.intSecondValue();
        Integer resultB = first.intSecondValue() * second.intSecondValue();
        return new TRational(resultA, resultB);
    }

    @Override
    public CompositeNumber multiply(CompositeNumber first, CompositeNumber second) {
        return new TRational(first.intFirstValue() * second.intFirstValue(),
                first.intSecondValue() * second.intSecondValue());
    }

    @Override
    public CompositeNumber multiplyByNumber(int first, CompositeNumber second) {
        return new TRational(first * second.intFirstValue(), second.intSecondValue());
    }

    @Override
    public CompositeNumber division(CompositeNumber first, CompositeNumber second) {
        return new TRational(first.intFirstValue() * second.intSecondValue(),
                first.intSecondValue() * second.intFirstValue());
    }

    @Override
    public double abs(CompositeNumber number) {
        return Math.abs(number.doubleFirstValue() / number.doubleSecondValue());
    }

    @Override
    public CompositeNumber[][] editValues(String[][] matrix) {
        TRational[][] newMatrix = new TRational[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                while(true) {
                    try {
                        newMatrix[i][j] = new TRational(matrix[i][j]);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        return newMatrix;
    }
}
