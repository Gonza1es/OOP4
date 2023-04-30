package com.example.oop4;

public class SquareMatrix<T extends CompositeNumber> extends Matrix<T>{

    public SquareMatrix(T[][] matrix, CompositeNumberUtils<T> compositeNumberUtils) {
        super(matrix, compositeNumberUtils);
    }

    public SquareMatrix(String input, CompositeNumberUtils<T> compositeNumberUtils) {
        super(input, compositeNumberUtils);
    }

    @Override
    public String getCalculateDeterminant() {
        return "Определитель матрицы = " + calculateDeterminant(matrix);
    }

    private CompositeNumber calculateDeterminant(T[][] matrix) {
        T calcResult = (T) CompositeNumber.getDefaultValue(matrix[0][0]);
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
                calcResult = compositeNumberUtils.sum(calcResult, compositeNumberUtils.multiply(compositeNumberUtils.multiplyByNumber(koeff,matrix[0][i]), (T) calculateDeterminant(getMinor(matrix, 0, i))));
            }
        }
        return calcResult;
    }

    private T[][] getMinor(CompositeNumber[][] matrix, int row, int column) {
        int minorLength = matrix.length - 1;
        T[][] minor = (T[][]) new CompositeNumber[minorLength][minorLength];
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
                        minor[i - dI][j - dJ] = (T) matrix[i][j];
                    }
                }
            }
        }
        return minor;
    }


}
