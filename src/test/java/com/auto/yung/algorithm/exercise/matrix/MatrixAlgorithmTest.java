package com.auto.yung.algorithm.exercise.matrix;

import org.junit.Before;
import org.junit.Test;

/**
 * @author yungwang
 * @date 2019/7/28.
 */
public class MatrixAlgorithmTest {

    private char[][] matrix;

    private int[][] matrixNumber;

    private MatrixAlgorithm algorithm;

    @Before
    public void setUp() throws Exception {
        matrix = new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        matrixNumber = new int[][]{{0, 1, 2, 5}, {2, 3, 4, 7}, {4, 4, 4, 8}, {5, 7, 7, 9}};
        algorithm = new MatrixAlgorithm();
    }

    @Test
    public void existStr() throws Exception {
        boolean rt = algorithm.existStr(matrix, "ABCCED");
        System.out.println(rt);
    }

    @Test
    public void existsNumber() {
        boolean rt = algorithm.existsNumber(matrixNumber, 8);
        System.out.println(rt);
    }

    @Test
    public void ktnSmallest() {
        matrixNumber = new int[][]{{1, 5, 7}, {3, 7, 8}, {4, 8, 9}};
        int number = algorithm.kthSmallest(matrixNumber, 4);
        System.out.println(number);
    }
}