package com.auto.yung.algorithm.exercise.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yungwang
 * @date 2019/7/7.
 */
public class BinaryTreeNodeTraversalTest {

    int[] preOrder = new int[] {1,2,4,7,3,5,6,8};
    int[] inOrder = new int[] {4,7,2,1,5,3,8,6};
    private BinaryTreeNode root;
    private BinaryTreeNodeTraversal treeNodeTraversal;
    @Before
    public void setUp() throws Exception {
        treeNodeTraversal = new BinaryTreeNodeTraversal();
        root = BinaryTreeNodeFactory.create(preOrder,inOrder);
    }

    @Test
    public void printPreOrder() throws Exception {
        String sb = treeNodeTraversal.printPreOrder(root);
        System.out.println(sb);
    }

    @Test
    public void printPostOrder() {
        String sb = treeNodeTraversal.printPostOrder(root);
        System.out.println(sb);
    }

    @Test
    public void printInOrder() {
        String sb = treeNodeTraversal.printInOrder(root);
        System.out.println(sb);
    }

    @Test
    public void reverse() {
        treeNodeTraversal.reverse(root);
        String sb = treeNodeTraversal.printPreOrder(root);
        System.out.println(sb);
    }
}