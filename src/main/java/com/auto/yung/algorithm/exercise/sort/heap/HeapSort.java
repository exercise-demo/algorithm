package com.auto.yung.algorithm.exercise.sort.heap;

/**
 * @author yungwang
 * @date 2019/7/20.
 */
public class HeapSort {

    public void sort(int[] array) {
        if (array == null) {
            return;
        }
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }
        for (int j = array.length - 1; j > 0; j--) {
            swap(array, 0, j);
            adjustHeap(array, 0, j);
        }
    }

    private void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            if (array[k] > temp) {
                swap(array, i, k);
                i = k;
            } else {
                break;
            }
        }
    }

    public void sort1(int[] array) {
        if (array == null) {
            return;
        }
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap1(array, i, array.length);
        }
        for (int j = array.length - 1; j > 0; j--) {
            swap(array, 0, j);
            adjustHeap1(array, 0, j);
        }
    }

    private void adjustHeap1(int[] array, int i, int length) {
        if (i >= length) {
            return;
        }
        int temp = array[i];
        int k = 2 * i + 1;
        while (k < length) {
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            if (array[k] > temp) {
                swap(array, i, k);
                i = k;
                k = 2 * k + 1;
            } else {
                break;
            }
        }
    }

    private void swap(int[] array, int i, int k) {
        int temp = array[i];
        array[i] = array[k];
        array[k] = temp;
    }
}
