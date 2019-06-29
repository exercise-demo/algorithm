package com.auto.yung.algorithm.exercise.sort;

import org.junit.Before;
import org.junit.Test;

/**
 * @author yung
 * @date 2019-05-24 15:49
 * <p>
 *     快速排序
 * </p>
 */
public class QuickSortTest {

    private int[] array = {};
    private QuickSort quickSort;

    @Before
    public void setUp() throws Exception {
        array = new int[]{213, 21, 764, 34, 214, 556, 76,213, 2, 3, 54, 789, 23, 45, 90, 87};
        quickSort = new QuickSort();

    }

    @Test
    public void quickSort() {
        quickSort.quickSort(array);
        for (int item : array) {
            System.out.print(item + ";");
        }
    }

    @Test
    public void quickSortNotR() {
        quickSort.quickSortNotR(array);
        for (int item : array) {
            System.out.print(item + ";");
        }
    }
}