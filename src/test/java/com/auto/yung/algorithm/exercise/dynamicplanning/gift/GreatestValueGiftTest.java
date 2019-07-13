package com.auto.yung.algorithm.exercise.dynamicplanning.gift;

import org.junit.Before;
import org.junit.Test;

/**
 * @author yungwang
 * @date 2019/7/13.
 */
public class GreatestValueGiftTest {

    private GreatestValueGift greatestValueGift;
    private int[][] matrix = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};

    @Before
    public void setUp() throws Exception {
        greatestValueGift = new GreatestValueGift();
    }

    @Test
    public void getGreatestValueSolution1() throws Exception {
        int max = greatestValueGift.getGreatestValueSolution1(matrix);
        System.out.println("max:" + max);
    }

}