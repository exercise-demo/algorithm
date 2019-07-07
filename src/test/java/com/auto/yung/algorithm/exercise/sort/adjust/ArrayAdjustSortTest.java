package com.auto.yung.algorithm.exercise.sort.adjust;

import org.junit.Before;
import org.junit.Test;

/**
 * @author yungwang
 * @date 2019/7/7.
 */
public class ArrayAdjustSortTest {

    private ArrayAdjustSort arrayAdjustSort;

    @Before
    public void setUp() throws Exception {
        arrayAdjustSort = new ArrayAdjustSort();
    }

    @Test
    public void reOrderOddEvent() throws Exception {
        int[] array = new int[]{1, 21, 432, 123, 435, 34, 646, 645, 12, 32, 34, 432, 1221};
        System.out.println("before:" + print(array));
        arrayAdjustSort.reOrderOddEvent(array);
        System.out.println("After:" + print(array));
    }

    @Test
    public void reOrderNegative() throws Exception {
        int[] array = new int[]{1, -21, 432, 123, -435, 34, 646, 645, 12, -32, 34, -432, -1221};
        System.out.println("before:" + print(array));
        arrayAdjustSort.reOrderNegative(array);
        System.out.println("After:" + print(array));
    }

    private String print(int[] array) {
        if (array == null || array.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int item : array) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(item);
        }
        return sb.toString();
    }

}