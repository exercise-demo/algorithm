package com.auto.yung.algorithm.exercise.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yung
 * @date 2019-05-23 11:48
 * <p>
 * 归并算法（从上往下）
 * </p>
 * <p>
 * 时间复杂度                空间复杂度  稳定性
 * 平均情况  最好情况 最坏情况  辅助存储   稳定
 * O(nlogn)    O(n2)  O(n2)     O(1)
 * </p>
 */
public class MergeSort {

    public void mergeSort(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = list.size();
        sort(list, 0, size - 1);
    }

    public void mergeSort(int[] list) {
        if (list == null || list.length == 0) {
            return;
        }
        sort(list, 0, list.length - 1);
    }

    private void sort(List<Integer> list, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sort(list, start, mid);
        sort(list, mid + 1, end);
        mergeData(list, start, mid, end);
    }

    private void sort(int[] list, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sort(list, start, mid);
        sort(list, mid + 1, end);
        mergeData(list, start, mid, end);
    }

    private void mergeData(List<Integer> list, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        List<Integer> temp = new ArrayList<Integer>();
        while (i <= mid && j <= end) {
            if (list.get(i) <= list.get(j)) {
                temp.add(list.get(i++));
            } else {
                temp.add(list.get(j++));
            }
        }
        while (i <= mid) {
            temp.add(list.get(i++));
        }
        while (j <= end) {
            temp.add(list.get(j++));
        }

        for (Integer item : temp) {
            list.set(start++, item);
        }
    }

    private void mergeData(int[] list, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (list[i] <= list[j]) {
                temp[k++] = list[i++];
            } else {
                temp[k++] = list[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = list[i++];
        }
        while (j <= end) {
            temp[k++] = list[j++];
        }

        for (int item : temp) {
            list[start++] = item;
        }
    }

    public int[] mergeData(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return null;
        }
        return sortMerge(arrays, 0, arrays.length - 1);
    }

    private int[] sortMerge(int[][] arrays, int start, int end) {
        if (end <= start) {
            return arrays[start];
        }
        int mid = (start + end) / 2;
        int[] left = sortMerge(arrays, start, mid);
        int[] right = sortMerge(arrays, mid + 1, end);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        if (left == null) {
            return left;
        }
        if (right == null) {
            return right;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int[] temp = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                temp[k++] = left[i++];
            } else {
                temp[k++] = right[j++];
            }
        }
        while (i < left.length) {
            temp[k++] = left[i++];
        }
        while (j < right.length) {
            temp[k++] = right[j++];
        }
        return temp;
    }
}
