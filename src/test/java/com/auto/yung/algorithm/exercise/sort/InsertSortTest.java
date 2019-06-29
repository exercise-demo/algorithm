package com.auto.yung.algorithm.exercise.sort;

import org.junit.Before;
import org.junit.Test;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.*;

/**
 * @author yung
 * @date 2019-06-19 15:03
 */
public class InsertSortTest {

    private int[] array = {};

    private InsertSort insertSort;

    @Before
    public void setUp() throws Exception {
        array = new int[]{213, 21, 764, 34, 214, 556, 76,213, 2, 3, 54, 789, 23, 45, 90, 87};
        insertSort = new InsertSort();
    }

    @Test
    public void insertSort1() {
        insertSort.insertSort1(array);
        for (int item : array) {
            System.out.print(item + ";");
        }
    }

    @Test
    public void insertSort2() {
        insertSort.insertSort2(array);
        for (int item : array) {
            System.out.print(item + ";");
        }
    }
}