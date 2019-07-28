package com.auto.yung.algorithm.exercise.sort;

/**
 * @author yungwang
 * @date 2019/7/28.
 */
public class KthNumberAlgorithm {

    /**
     * 求最大的k个数
     *
     * @param input
     * @param k
     * @return
     */
    public int[] getMaxKthNumber(int[] input, int k) {
        if (input == null || k <= 0) {
            return null;
        }
        if (input.length < k) {
            return input;
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = input[i];
        }
        for (int j = k / 2 - 1; j >= 0; j--) {
            adjustMinHeap(ret, j, k);
        }
        for (int i = k; i < input.length; i++) {
            if (input[i] > ret[0]) {
                ret[0] = input[i];
                adjustMinHeap(ret, 0, k);
            }
        }
        return ret;
    }

    /**
     * 最小堆
     *
     * @param array
     * @param head
     * @param length
     */
    private void adjustMinHeap(int[] array, int head, int length) {
        if (head >= length) {
            return;
        }
        int k = 2 * head + 1;
        int temp = array[head];
        while (k < length) {
            if (k + 1 < length && array[k] > array[k + 1]) {
                k++;
            }
            if (array[k] < temp) {
                array[head] = array[k];
                head = k;
                k = 2 * k + 1;
            } else {
                break;
            }
        }
        array[head] = temp;
    }

    /**
     * 求最小的k个数
     *
     * @param array
     * @param k
     * @return
     */
    public int[] getLeastKthNumber(int[] array, int k) {
        if (array == null || k <= 0) {
            return null;
        }
        if (k > array.length) {
            return array;
        }
        int[] ret = new int[k];
        System.arraycopy(array, 0, ret, 0, k);
        for (int j = k / 2 - 1; j >= 0; j--) {
            adjustMaxHeap(ret, j, k);
        }
        for (int i = k; i < array.length; i++) {
            if (array[i] < ret[0]) {
                ret[0] = array[i];
                adjustMaxHeap(ret, 0, k);
            }
        }
        return ret;
    }

    private void adjustMaxHeap(int[] array, int head, int length) {
        if (head >= length) {
            return;
        }
        int temp = array[head];
        int k = 2 * head + 1;
        while (k < length) {
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            if (array[k] > temp) {
                array[head] = array[k];
                head = k;
                k = 2 * k + 1;
            } else {
                break;
            }
        }
        array[head] = temp;
    }
}
