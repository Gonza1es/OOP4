package com.example.oop4;

public class MatrixFactory {

    public static MatrixUtils getMatrix(String input, String type) {
        String[] rows = input.split("\n");
        String[] column = rows[0].split(" ");
        if (rows.length == column.length) {
            return getSquareMatrixObject(input, type);
        } else {
            return getMatrixObject(input, type);
        }
    }

    private static SquareMatrix<?> getSquareMatrixObject(String input, String type) {
        ElementType elementType = ElementType.valueOf(type);
        return switch (elementType) {
            case COMPLEX -> new SquareMatrix<TComplex>(input, new TComplexUtils());
            case RATIONAL -> new SquareMatrix<TRational>(input, new TRationalUtils());
            case DEFAULT -> new SquareMatrix<RealNumber>(input, new RealNumberUtils());
        };
    }

    private static Matrix<?> getMatrixObject(String input, String type) {
        ElementType elementType = ElementType.valueOf(type);
        return switch (elementType) {
            case COMPLEX -> new Matrix<TComplex>(input, new TComplexUtils());
            case RATIONAL -> new Matrix<TRational>(input, new TRationalUtils());
            case DEFAULT -> new Matrix<RealNumber>(input, new RealNumberUtils());
        };
    }
}
