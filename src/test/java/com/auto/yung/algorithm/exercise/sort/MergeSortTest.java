package com.auto.yung.algorithm.exercise.sort;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yung
 * @date 2019-05-23 12:17
 */
public class MergeSortTest {


    @Test
    public void mergeSort() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(23);
        list.add(12);
        list.add(212);
        list.add(102);
        list.add(89);
        list.add(34);
        list.add(55);
        list.add(3);
        list.add(66);
        list.add(345);
        list.add(23);
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(list);
        System.out.println(list);
    }

    @Test
    public void mergeSort1() {
        int[] list = new int[] {23,12,212,102,89,34,55,3,66,345,23};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(list);
        System.out.println(list);
    }
}
