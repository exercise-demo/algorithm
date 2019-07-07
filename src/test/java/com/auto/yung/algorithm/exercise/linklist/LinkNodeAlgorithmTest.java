package com.auto.yung.algorithm.exercise.linklist;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author yungwang
 * @date 2019/7/6.
 */
public class LinkNodeAlgorithmTest {

    private LinkNode root;

    private LinkNode toBeDeleted;

    private int[] array;

    private LinkNodeAlgorithm linkNodeAlgorithm;

    @Before
    public void setUp() throws Exception {
        linkNodeAlgorithm = new LinkNodeAlgorithm();
        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        root = LinkListFactory.createLinkList(array);
        toBeDeleted = LinkListFactory.findValue(root, 6);
    }

    @Test
    public void deleteNode1() throws Exception {
        System.out.println("root：");
        linkNodeAlgorithm.printNode(root);
        root = linkNodeAlgorithm.deleteNode(root, toBeDeleted);
        System.out.println("deleted：");
        linkNodeAlgorithm.printNode(root);
    }

    @Test
    public void deleteNode2() throws Exception {
        int[] array1 = new int[]{24};
        root = LinkListFactory.createLinkList(array1);
        toBeDeleted = root;
        System.out.println("root：");
        linkNodeAlgorithm.printNode(root);
        root = linkNodeAlgorithm.deleteNode(root, toBeDeleted);
        System.out.println("deleted：");
        linkNodeAlgorithm.printNode(root);
    }

    @Test
    public void deleteNode3() throws Exception {
        toBeDeleted = LinkListFactory.findValue(root,9);
        System.out.println("root：");
        linkNodeAlgorithm.printNode(root);
        root = linkNodeAlgorithm.deleteNode(root, toBeDeleted);
        System.out.println("deleted：");
        linkNodeAlgorithm.printNode(root);
    }

    @Test
    public void deleteDuplicate1() {
        LinkNode node = LinkListFactory.createLinkList(new int[] {1,2,3,4,4,5,5,6});
        node = linkNodeAlgorithm.deleteDuplicateNode(node);
        linkNodeAlgorithm.printNode(node);
    }

    @Test
    public void findKthToTail() {
        LinkNode node = LinkListFactory.createLinkList(new int[] {1,2,3,4,5,6,7,8,9});
        System.out.println("root：");
        linkNodeAlgorithm.printNode(node);
        node = linkNodeAlgorithm.findKthToTail(node, 3);
        System.out.println("findKthToTail：");
        linkNodeAlgorithm.printNode(node);
    }

    @Test
    public void reverseList() {
        LinkNode node = LinkListFactory.createLinkList(new int[] {1,2,3,4,5,6,7,8,9});
        System.out.println("root：");
        linkNodeAlgorithm.printNode(node);
        node = linkNodeAlgorithm.reverseList(node);
        System.out.println("reverseList：");
        linkNodeAlgorithm.printNode(node);
    }

    @Test
    public void merge() {
        LinkNode node1 = LinkListFactory.createLinkList(new int[] {1,23,34,35,234,532});
        LinkNode node2 = LinkListFactory.createLinkList(new int[] {21,24,26,52,45,431});
        LinkNode merge = linkNodeAlgorithm.merge(node1,node2);
        System.out.println("merge：");
        linkNodeAlgorithm.printNode(merge);
    }
}