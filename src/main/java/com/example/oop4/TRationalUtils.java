package com.example.oop4;

public class TRationalUtils implements CompositeNumberUtils<TRational>{

    @Override
    public TRational sum(TRational first, TRational second) {
        Integer resultA = first.intFirstValue() * second.intSecondValue() + second.intFirstValue() * first.intSecondValue();
        Integer resultB = first.intSecondValue() * second.intSecondValue();
        return new TRational(resultA, resultB);
    }

    @Override
    public TRational subtract(TRational first, TRational second) {
        Integer resultA = first.intFirstValue() * second.intSecondValue() - second.intFirstValue() * first.intSecondValue();
        Integer resultB = first.intSecondValue() * second.intSecondValue();
        return new TRational(resultA, resultB);
    }

    @Override
    public TRational multiply(TRational first, TRational second) {
        return new TRational(first.intFirstValue() * second.intFirstValue(),
                first.intSecondValue() * second.intSecondValue());
    }

    @Override
    public TRational multiplyByNumber(int first, TRational second) {
        return new TRational(first * second.intFirstValue(), second.intSecondValue());
    }

    @Override
    public TRational division(TRational first, TRational second) {
        return new TRational(first.intFirstValue() * second.intSecondValue(),
                first.intSecondValue() * second.intFirstValue());
    }

    @Override
    public double abs(TRational number) {
        return Math.abs(number.doubleFirstValue() / number.doubleSecondValue());
    }

    @Override
    public TRational[][] editValues(String[][] matrix) {
        TRational[][] newMatrix = new TRational[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
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
