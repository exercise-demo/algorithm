package com.auto.yung.algorithm.exercise.sort;

import org.junit.Before;
import org.junit.Test;

/**
 * @author yung
 * @date 2019-05-28 15:03
 */
public class SelectionSortTest {

    private SelectionSort selectionSort;
    private int[] array = {};

    @Before
    public void setUp() throws Exception {
        selectionSort = new SelectionSort();
        array = new int[]{213, 21, 764, 34, 214, 556, 76,213, 2, 3, 54, 789, 23, 45, 90, 87};
    }

    @Test
    public void simpleSort() {
        selectionSort.simpleSort(array);
        for (int item : array) {
            System.out.print(item + ";");
        }
    }
}