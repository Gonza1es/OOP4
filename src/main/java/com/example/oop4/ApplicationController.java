package com.example.oop4;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    private final TRationalUtils utils = new TRationalUtils();

    @PostMapping("/determinant")
    public String getCalculateDeterminant(@RequestBody String matrix) {
        MatrixUtils mtrx = MatrixFactory.getMatrix(matrix, utils);
        return mtrx.getCalculateDeterminant();
    }

    @PostMapping("/transpose")
    public String getTransposeMatrix(@RequestBody String matrix) {
        MatrixUtils mtrx = MatrixFactory.getMatrix(matrix, utils);
        return mtrx.getTransposeMatrix();
    }

    @PostMapping("/rank")
    public String getRankMatrix(@RequestBody String matrix) {
        MatrixUtils mtrx = MatrixFactory.getMatrix(matrix, utils);
        return mtrx.getRankString();
    }
}
