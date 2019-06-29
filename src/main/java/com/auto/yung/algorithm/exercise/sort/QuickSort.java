package com.auto.yung.algorithm.exercise.sort;

import java.util.Stack;

/**
 * @author yung
 * @date 2019-05-24 15:28
 * <br>
 * 快速排序
 * </br>
 * * <p>
 * *     时间复杂度                    空间复杂度  稳定性
 * *     平均情况    最好情况   最坏情况  辅助存储   不稳定
 * *     O(nlogn)   O(nlogn)  O(n2)   O(nlogn)
 * * </p>
 */
public class QuickSort {

    public void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    public void quickSortNotR(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        sortNotR(array, 0, array.length - 1);
    }

    /**
     * 递归实现
     *
     * @param array
     * @param start
     * @param end
     */
    private void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int base = partSort(array, start, end);
        sort(array, start, base - 1);
        sort(array, base + 1, end);
    }

    /**
     * 非递归实现
     *
     * @param array
     * @param start
     * @param end
     */
    private void sortNotR(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(start);
        stack.push(end);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            int index = partitionSwap(array, left, right);
            if ((index - 1) > left) {
                stack.push(left);
                stack.push(index - 1);
            }
            if ((index + 1) < right) {
                stack.push(index + 1);
                stack.push(right);
            }
        }
    }

    /**
     * 左右指针法
     * 分割数组1
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int partitionSwap(int[] array, int start, int end) {
        int v = array[start];
        while (start < end) {
            while (start < end && array[end] >= v) {
                end--;
            }
            if (array[end] < v) {
                swap(array, start, end);
                ++start;
            }
            while (start < end && array[start] <= v) {
                start++;
            }
            if (array[start] > v) {
                swap(array, start, end);
                end--;
            }
        }
        return start;
    }

    /**
     * 左右指针法
     * 分割数组2
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int partitionSwap2(int[] array, int start, int end) {
        int s = start;
        int v = array[start];
        while (start < end) {
            while (start < end && array[end] >= v) {
                end--;
            }
            while (start < end && array[start] <= v) {
                start++;
            }
            swap(array, start, end);
        }
        swap(array, start, s);
        return start;
    }

    /**
     * 挖坑法
     * 以左边起点作为基准
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int partitionLeft(int[] array, int start, int end) {
        int v = array[start];
        while (start < end) {
            while (start < end && array[end] >= v) {
                end--;
            }
            array[start] = array[end];
            while (start < end && array[start] <= v) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = v;
        return start;
    }

    /**
     * 挖坑法
     * 以右边末尾作为基准
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int partitionRight(int[] array, int start, int end) {
        int v = array[end];
        while (start < end) {
            while (start < end && array[start] <= v) {
                start++;
            }
            array[end] = array[start];
            while (start < end && array[end] >= v) {
                end--;
            }
            array[start] = array[end];
        }
        array[start] = v;
        return start;
    }

    /**
     * 前后指针法
     * 可针对 链表进行排序
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int partSort(int[] array, int start, int end) {
        if (start > end) {
            return -1;
        }
        int key = array[end];
        int pre = start - 1;
        int cur = start;
        while (cur < end) {
            while (array[cur] < key && array[++pre] != array[cur]) {
                swap(array, cur, pre);
            }
            ++cur;
        }
        swap(array, ++pre, end);
        return pre;
    }


    /**
     * 交换元素内容
     *
     * @param array
     * @param i
     * @param j
     */
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int getIndex(int start, int end, int type) {
        switch (type) {
            case 0:
                return start;
            case 1:
                return end;
            default:
                return (start + end) / 2;
        }

    }

    /**
     * 获取基准数
     * type 0:第一个作为基准数 1：最后一个作为基准数 其他：中间位作为基准数
     *
     * @param array
     * @param start
     * @param end
     * @param type
     * @return
     */
    private int getBaseData(int[] array, int start, int end, int type) {
        if (type == 0) {
            return array[start];
        } else if (type == 1) {
            return array[end];
        } else {
            return array[(start + end) / 2];
        }
    }
}
