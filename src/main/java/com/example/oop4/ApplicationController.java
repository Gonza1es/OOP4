package com.example.oop4;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    @PostMapping("/determinant")
    public String getCalculateDeterminant(@RequestBody String matrix,
                                          @RequestParam String type) {
        MatrixUtils mtrx = MatrixFactory.getMatrix(matrix, type);
        return mtrx.getCalculateDeterminant();
    }

    @PostMapping("/transpose")
    public String getTransposeMatrix(@RequestBody String matrix,
                                     @RequestParam String type) {
        MatrixUtils mtrx = MatrixFactory.getMatrix(matrix, type);
        return mtrx.getTransposeMatrix();
    }

    @PostMapping("/rank")
    public String getRankMatrix(@RequestBody String matrix,
                                @RequestParam String type) {
        MatrixUtils mtrx = MatrixFactory.getMatrix(matrix, type);
        return mtrx.getRankString();
    }
}
