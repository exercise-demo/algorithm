package com.auto.yung.algorithm.exercise.sort.heap;

import org.junit.Before;
import org.junit.Test;

/**
 * @author yungwang
 * @date 2019/7/20.
 */
public class HeapSortTest {

    private int[] array;

    private HeapSort heapSort;

    @Before
    public void setUp() throws Exception {
        array = new int[]{2, 35, 32, 12, 53, 231, 52, 4, 5};
        heapSort = new HeapSort();
    }

    @Test
    public void sort() throws Exception {
        heapSort.sort(array);
        System.out.println(printString(array));
    }

    @Test
    public void sort1() throws Exception {
        heapSort.sort1(array);
        System.out.println(printString(array));
    }

    private String printString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i).append(",");
        }
        return sb.toString();
    }

}