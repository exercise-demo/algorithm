package com.auto.yung.algorithm.exercise.dynamicplanning.gift;

/**
 * @author yungwang
 * @date 2019/7/13.
 */
public class GreatestValueGift {

    /***
     *  从 m*n 的棋盘的每一格都放下一个礼物，每个礼物放有一定的价值（价值大于0）。
     *  你可以从棋盘左上角开始拿格子里的礼物，并每次从左或向下移动一格，直到到达棋盘的右下角
     *  计算最多能拿到多少价值的礼物
     * <p>
     *     方法: 循环法，建立辅助缓存(动态规划)
     * </p>
     *
     * @param matrix
     * @return
     */
    public int getGreatestValueSolution1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] maxValues = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
            maxValues[i] = new int[cols];
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = maxValues[i - 1][j];
                }
                if (j > 0) {
                    left = maxValues[i][j - 1];
                }
                maxValues[i][j] = max(left, up) + matrix[i][j];
            }
        }
        return maxValues[rows - 1][cols - 1];
    }

    private int max(int left, int up) {
        return left > up ? left : up;
    }
}
