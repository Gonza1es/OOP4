package com.example.oop4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matrix {
    private CompositeNumber[][] matrix;
    private final int size;

    private final CompositeNumberUtils compositeNumberUtils;


    public Matrix(CompositeNumber[][] matrix, CompositeNumberUtils compositeNumberUtils) {
        this.size = matrix.length;
        this.matrix = matrix.clone();
        this.compositeNumberUtils = compositeNumberUtils;
    }

    public Matrix(String input, CompositeNumberUtils compositeNumberUtils) {
        this.compositeNumberUtils = compositeNumberUtils;
        String[] rows = input.split("\n");
        String[][] stringMatrixElements = new String[rows.length][rows.length];

        for (int i = 0; i < rows.length; i++) {
            String[] elements = rows[i].split(" ");
            for (int j = 0; j < elements.length; j++) {
                stringMatrixElements[i][j] = elements[j];
            }
        }
        this.matrix = compositeNumberUtils.editValues(stringMatrixElements);
        this.size = matrix.length;
    }

    public void calculateDeterminant() {
        System.out.println("Определитель матрицы = " + calculateDeterminant(matrix));
    }

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

    public void transpose() {
        CompositeNumber[][] transposeMatrix = new CompositeNumber[matrix.length][matrix.length];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }

        System.out.println("Транспонированная матрица: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(transposeMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public String getTransposeMatrix() {
        CompositeNumber[][] transpose = new CompositeNumber[matrix.length][matrix.length];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return toString(transpose);
    }

    public void editMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новые значения матрицы (Пример - 1+2i): ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                while(true) {
                    String complex = scanner.nextLine();
                    try {
                        matrix[i][j] = null;
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
    public void editMatrixByGUI(String input) {
        String[][] stringMatrixElements = new String[matrix.length][matrix.length];
        String[] rows = input.split("\n");

        for (int i = 0; i < rows.length; i++) {
            String[] elements = rows[i].split(" ");
            for (int j = 0; j < elements.length; j++) {
                stringMatrixElements[i][j] = elements[j];
            }
        }
        this.matrix = compositeNumberUtils.editValues(stringMatrixElements);
    }

    public void calculateRank() {
        System.out.println(getRankString());
    }

    public String getRankString() {
        return "Ранг матрицы = " + calcRank();
    }

    private int calcRank() {
        double EPS = 1E-9;
        CompositeNumber[][] currentMatrix = new CompositeNumber[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, currentMatrix[i], 0, matrix.length);
        }
        int rank = matrix.length;
        List<Boolean> lineUsed = new ArrayList<>();
        int j;
        for (int i = 0; i < matrix.length; i++) {
            lineUsed.add(i, false);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix.length; j++)
                if (!lineUsed.get(j) && compositeNumberUtils.abs(currentMatrix[j][i]) > EPS)
                    break;
            if (j == matrix.length)
                --rank;
            else {
                lineUsed.set(j, true);
                for (int p = i + 1; p < matrix.length; ++p)
                    currentMatrix[j][p] = compositeNumberUtils.division(currentMatrix[j][p], currentMatrix[j][i]);
                for (int k = 0; k < matrix.length; ++k)
                    if (k != j && compositeNumberUtils.abs(currentMatrix[k][i]) > EPS)
                        for (int p = i + 1; p < matrix.length; ++p)
                            currentMatrix[k][p] = compositeNumberUtils.division(currentMatrix[k][p],compositeNumberUtils.multiply(currentMatrix[j][p], currentMatrix[k][i]));
            }
        }
        return rank;
    }

    public void printMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public String getMatrix() {
        return toString(this.matrix);
    }

    private String toString(CompositeNumber[][] matrix) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                string.append(matrix[i][j].toString()).append(" ");
            }
            string.append("\n");
        }
        return string.toString();
    }
}
