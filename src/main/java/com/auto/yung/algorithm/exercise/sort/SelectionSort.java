package com.auto.yung.algorithm.exercise.sort;

/**
 * @author yung
 * @date 2019-05-27 17:53
 * <b>
 *    选择排序
 * </b>
 * <p>
 *     时间复杂度                空间复杂度  稳定性
 *     平均情况  最好情况 最坏情况  辅助存储   不稳定
 *     O(n2)    O(n2)  O(n2)     O(1)
 * </p>
 */
public class SelectionSort {

    public void simpleSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int k = i;
            for (int j = k + 1; j <= array.length - 1; j++) {
                if (array[j] < array[k]) {
                    k = j;
                }
            }
            if (i != k) {
                swap(array, i, k);
            }
        }

    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
