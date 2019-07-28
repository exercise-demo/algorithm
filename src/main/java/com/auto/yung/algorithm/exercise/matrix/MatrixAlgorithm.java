package com.auto.yung.algorithm.exercise.matrix;

/**
 * @author yungwang
 * @date 2019/7/28.
 */
public class MatrixAlgorithm {

    /**
     * 二维矩阵中是否存在 字符串
     *
     * @param matrix
     * @param string
     * @return
     */
    public boolean existStr(char[][] matrix, String string) {
        if (matrix == null || string.length() <= 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (search(matrix, 0, i, j, string, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] matrix, int index, int rowIndex, int colIndex, String str,
                           boolean[][] visited) {
        if (index == str.length()) {
            return true;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rowIndex < 0 || colIndex < 0 || rowIndex >= rows || colIndex >= cols) {
            return false;
        }
        if (visited[rowIndex][colIndex]) {
            return false;
        }
        if (matrix[rowIndex][colIndex] != str.charAt(index)) {
            return false;
        }
        visited[rowIndex][colIndex] = true;
        boolean res = search(matrix, index + 1, rowIndex + 1, colIndex, str, visited)
                || search(matrix, index + 1, rowIndex - 1, colIndex, str, visited)
                || search(matrix, index + 1, rowIndex, colIndex + 1, str, visited)
                || search(matrix, index + 1, rowIndex, colIndex - 1, str, visited);
        visited[rowIndex][colIndex] = false;
        return res;
    }

    /**
     * 在有序矩阵中查找 k
     *
     * @param matrix
     * @param k
     * @return
     */
    public boolean existsNumber(int[][] matrix, int k) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < rows && col >= 0) {
            if (matrix[row][col] == k) {
                return true;
            } else if (matrix[row][col] > k) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    /**
     * 有序矩阵第k小的数
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length <= 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix.length;
        if (k > rows * cols) {
            return 0;
        }
        int[] rowArray = new int[rows];
        int ret = 0;
        for (int j = 0; j < k; j++) {
            int temp = Integer.MAX_VALUE;
            int flag = 0;
            for (int i = 0; i < rowArray.length; i++) {
                if (rowArray[i] < cols) {
                    if (matrix[i][rowArray[i]] < temp) {
                        temp = matrix[i][rowArray[i]];
                        flag = i;
                    }
                }
            }
            rowArray[flag]++;
            ret = temp;
        }
        return ret;
    }
}
