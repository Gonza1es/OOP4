package com.example.oop4;

public class SquareMatrix extends Matrix{

    public SquareMatrix(CompositeNumber[][] matrix, CompositeNumberUtils compositeNumberUtils) {
        super(matrix, compositeNumberUtils);
    }

    public SquareMatrix(String input, CompositeNumberUtils compositeNumberUtils) {
        super(input, compositeNumberUtils);
    }

    @Override
    public String getCalculateDeterminant() {
        return "Определитель матрицы = " + calculateDeterminant(matrix);
    }

    private CompositeNumber calculateDeterminant(CompositeNumber[][] matrix) {
        CompositeNumber calcResult = new TRational(0, 1);
        if (matrix.length == 2) {
            calcResult = compositeNumberUtils.subtract(compositeNumberUtils.multiply(matrix[0][0], matrix[1][1]), compositeNumberUtils.multiply(matrix[1][0], matrix[0][1]));
        } else {
            int koeff = 1;
            for (int i = 0; i < matrix.length; i++) {
                if (i % 2 == 1) {
                    koeff = -1;
                } else {
                    koeff = 1;
                }
                calcResult = compositeNumberUtils.sum(calcResult, compositeNumberUtils.multiply(compositeNumberUtils.multiplyByNumber(koeff,matrix[0][i]), calculateDeterminant(getMinor(matrix, 0, i))));
            }
        }
        return calcResult;
    }

    private CompositeNumber[][] getMinor(CompositeNumber[][] matrix, int row, int column) {
        int minorLength = matrix.length - 1;
        CompositeNumber[][] minor = new CompositeNumber[minorLength][minorLength];
        int dI = 0;
        int dJ = 0;
        for (int i = 0; i <= minorLength; i++) {
            dJ = 0;
            for (int j = 0; j <= minorLength; j++) {
                if (i == row) {
                    dI = 1;
                } else {
                    if (j == column) {
                        dJ = 1;
                    } else {
                        minor[i - dI][j - dJ] = matrix[i][j];
                    }
                }
            }
        }
        return minor;
    }


}
