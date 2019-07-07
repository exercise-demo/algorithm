package com.auto.yung.algorithm.exercise.sort.adjust;

/**
 * @author yungwang
 * @date 2019/7/7.
 * <p>
 * 调整 数组顺序
 * </p>
 */
public class ArrayAdjustSort {

    /**
     * 奇数在前，偶数在后半部分
     *
     * @param array
     */
    public void reOrderOddEvent(int[] array) {
        reOrder(array, (n) -> {
            return (n & 1) == 0;
        });
    }

    /**
     * 负数在前半部分，非负数在后半部分
     *
     * @param array
     */
    public void reOrderNegative(int[] array) {
        reOrder(array, (n) -> {
            return (n & 0x80000000) == 0;
        });
    }

    private void reOrder(int[] array, Condition condition) {
        if (array == null || array.length == 0) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            while (start < end && !condition.isCondition(array[start])) {
                ++start;
            }
            while (start < end && condition.isCondition(array[end])) {
                --end;
            }
            swap(array, start, end);
        }
    }

    private void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    interface Condition {
        /**
         * 是否符合条件
         *
         * @param n
         * @return
         */
        boolean isCondition(int n);
    }
}

