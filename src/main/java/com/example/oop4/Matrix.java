package com.example.oop4;


import java.util.ArrayList;
import java.util.List;

public class Matrix<T extends CompositeNumber> implements MatrixUtils{

    protected T[][] matrix;

    protected final CompositeNumberUtils<T> compositeNumberUtils;

    private Integer rows;
    private Integer columns;

    public Matrix(T[][] matrix, CompositeNumberUtils<T> compositeNumberUtils) {
        this.compositeNumberUtils = compositeNumberUtils;
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.matrix = matrix;
    }

    public Matrix(String input, CompositeNumberUtils<T> compositeNumberUtils) {
        this.compositeNumberUtils = compositeNumberUtils;
        String[] rows = input.split("\n");
        int columnCount = rows[0].split(" ").length;
        String[][] stringMatrixElements = new String[rows.length][columnCount];
        for (int i = 0; i < rows.length; i++) {
            String[] elements = rows[i].split(" ");
            for (int j = 0; j < elements.length; j++) {
                stringMatrixElements[i][j] = elements[j];
            }
        }
        this.matrix = compositeNumberUtils.editValues(stringMatrixElements);
        this.rows = matrix.length;
        this.columns = matrix[0].length;
    }

    @Override
    public String getTransposeMatrix(){
        String[][] transpose = new String[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transpose[j][i] = matrix[i][j].toString();
            }
        }
        return toString(transpose);
    }

    @Override
    public void editMatrixByGUI(String input){
        String[][] stringMatrixElements = new String[rows][columns];
        String[] rows = input.split("\n");

        for (int i = 0; i < rows.length; i++) {
            String[] elements = rows[i].split(" ");
            for (int j = 0; j < elements.length; j++) {
                stringMatrixElements[i][j] = elements[j];
            }
        }
        this.matrix = compositeNumberUtils.editValues(stringMatrixElements);
    }

    @Override
    public String getRankString(){
        double EPS = 1E-9;
        T[][] currentMatrix = (T[][]) new CompositeNumber[matrix.length][matrix.length];

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
        return "Ранг = " + rank;
    }

    @Override
    public String getMatrix() {
        return null;
    }

    @Override
    public String toString(String[][] matrix) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                string.append(matrix[i][j]).append(" ");
            }
            string.append("\n");
        }
        return string.toString();
    }

    @Override
    public String getCalculateDeterminant() {
        return "Определитель нельзя найти для неквадратной матрицы";
    }
}
