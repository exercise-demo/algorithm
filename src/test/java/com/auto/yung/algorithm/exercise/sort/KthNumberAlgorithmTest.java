package com.auto.yung.algorithm.exercise.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yungwang
 * @date 2019/7/28.
 */
public class KthNumberAlgorithmTest {

    private KthNumberAlgorithm numberAlgorithm;

    private int[] numbers;

    @Before
    public void setUp() throws Exception {
        numberAlgorithm = new KthNumberAlgorithm();
        numbers = new int[] {2, 35, 32, 12, 53, 231, 52, 4, 5};
    }

    @Test
    public void getMaxKthNumber() throws Exception {
        int[] ret = numberAlgorithm.getMaxKthNumber(numbers,4);
        print(ret);
    }

    @Test
    public void getLeastKthNumber() throws Exception {
        int[] ret = numberAlgorithm.getLeastKthNumber(numbers,4);
        print(ret);
    }

    private void print(int[] array) {
        if(array == null) {
            System.out.println();
        }
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}