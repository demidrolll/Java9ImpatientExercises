package org.demidrolll.java9impatient.ch10.task4;

import java.math.BigDecimal;
import java.util.Arrays;

public class Matrix {

    private final int rows;
    private final int cols;
    private final BigDecimal[][] data;

    public Matrix(int rows, int cols) {
        this.data = new BigDecimal[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public void set(int row, int col, BigDecimal value) {
        this.data[row][col] = value;
    }

    public BigDecimal get(int row, int col) {
        return data[row][col];
    }

    public Matrix multiply(Matrix other) {
        Matrix result = new Matrix(this.rows, other.cols);
        for (int row = 0; row < result.rows; row++) {
            for (int col = 0; col < result.cols; col++) {
                result.data[row][col] = multiplyItem(this, other, row, col);
            }
        }
        return result;
    }

    private BigDecimal multiplyItem(Matrix a, Matrix b, int row, int col) {
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 0; i < a.cols; i++) {
            sum = sum.add(a.data[row][i].multiply(b.data[i][col]));
        }
        return sum;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(data);
    }
}
