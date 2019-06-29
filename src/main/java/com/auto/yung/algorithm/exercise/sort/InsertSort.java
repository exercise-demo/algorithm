package com.auto.yung.algorithm.exercise.sort;

/**
 * @author yung
 * @date 2019-06-19 14:44
 * <br>
 * 插入排序
 * </br>
 * <p>
 * 时间复杂度                空间复杂度  稳定性
 * 平均情况  最好情况 最坏情况  辅助存储    稳定
 * O(n2)    O(n)   O(n2)     O(1)
 * </p>
 */
public class InsertSort {

    /**
     * 在第i个位置进行 循环交换
     */
    public void insertSort1(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 对大于i位置 前的数据依次往后移，最后将原始i位置数据赋值，第一个不大于temp的位置
     *
     * @param array
     */
    public void insertSort2(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int temp = array[i];
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }
}
