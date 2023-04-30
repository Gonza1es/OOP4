package com.example.oop4;

public class TComplexUtils implements CompositeNumberUtils<TComplex> {

    @Override
    public TComplex sum(TComplex first, TComplex second) {
        Number firstSum = first.doubleFirstValue() + second.doubleFirstValue();
        Number secondSum = second.doubleSecondValue() + second.doubleSecondValue();

        return new TComplex(firstSum, secondSum);
    }

    @Override
    public TComplex subtract(TComplex first, TComplex second) {
        Number firstSubtract = first.doubleFirstValue() - second.doubleFirstValue();
        Number secondSubtract = second.doubleSecondValue() - second.doubleSecondValue();

        return new TComplex(firstSubtract, secondSubtract);
    }

    @Override
    public TComplex multiply(TComplex first, TComplex second) {
        Number firstResult = first.doubleFirstValue() * second.doubleFirstValue() - first.doubleSecondValue()* second.doubleSecondValue();
        Number secondResult = first.doubleFirstValue() * second.doubleSecondValue() + first.doubleSecondValue() * second.doubleFirstValue();

        return new TComplex(firstResult, secondResult);
    }

    @Override
    public TComplex multiplyByNumber(int first, TComplex second) {
        Number firstResult = first * second.doubleFirstValue();
        Number secondResult = first * second.doubleSecondValue();

        return new TComplex(firstResult, secondResult);
    }

    @Override
    public TComplex division(TComplex first, TComplex second) {
        Number denominator = Math.pow(second.doubleFirstValue(), 2) + Math.pow(second.doubleSecondValue(), 2);
        Number firstNumerator = first.doubleFirstValue() * second.doubleFirstValue() + first.doubleSecondValue()* second.doubleSecondValue();
        Number secondNumerator = first.doubleFirstValue() * second.doubleSecondValue() - first.doubleSecondValue() * second.doubleFirstValue();
        Number firstResult = firstNumerator.doubleValue() / denominator.doubleValue();
        Number secondResult = secondNumerator.doubleValue() / denominator.doubleValue();

        return new TComplex(firstResult, secondResult);
    }

    @Override
    public double abs(TComplex complex) {
        return Math.sqrt(Math.pow(complex.doubleFirstValue(), 2) + Math.pow(complex.doubleSecondValue(), 2));
    }

    @Override
    public TComplex[][] editValues(String[][] matrix) {
        TComplex[][] newMatrix = new TComplex[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                    try {
                        newMatrix[i][j] = new TComplex(matrix[i][j]);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        return newMatrix;
    }
}
