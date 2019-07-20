package com.auto.yung.algorithm.exercise.tree;

import org.junit.Before;
import org.junit.Test;

/**
 * @author yungwang
 * @date 2019/7/7.
 */
public class BinaryTreeNodeTraversalTest {

    int[] preOrder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
    int[] inOrder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
    private BinaryTreeNode root;
    private BinaryTreeNodeTraversal treeNodeTraversal;

    @Before
    public void setUp() throws Exception {
        treeNodeTraversal = new BinaryTreeNodeTraversal();
        root = BinaryTreeNodeFactory.create(preOrder, inOrder);
    }

    @Test
    public void printPreOrder() throws Exception {
        String sb = treeNodeTraversal.printPreOrder(root);
        System.out.println("前序递归：" + sb);
        sb = treeNodeTraversal.printPreOrderR(root);
        System.out.println("前序非递归：" + sb);
        sb = treeNodeTraversal.printPreOrderR2(root);
        System.out.println("前序非递归2：" + sb);
    }

    @Test
    public void printPostOrder() {
        String sb = treeNodeTraversal.printPostOrder(root);
        System.out.println("后序递归：" + sb);
        sb = treeNodeTraversal.printPostOrderR(root);
        System.out.println("后序非递归：" + sb);
    }

    @Test
    public void printInOrder() {
        String sb = treeNodeTraversal.printInOrder(root);
        System.out.println("中序递归：" + sb);
        sb = treeNodeTraversal.printInOrderR(root);
        System.out.println("中序非递归：" + sb);
    }

    @Test
    public void kthNode() {
        BinaryTreeNode sb = treeNodeTraversal.kthNode(root, 5);
        System.out.println("kthNode：" + sb.getValue());
    }

    @Test
    public void reverse() {
        String sb = treeNodeTraversal.printPreOrder(root);
        System.out.println("原始：" + sb);
        treeNodeTraversal.reverse(root);
        sb = treeNodeTraversal.printPreOrder(root);
        System.out.println("反转：" + sb);
        treeNodeTraversal.reverseNotR(root);
        sb = treeNodeTraversal.printPreOrder(root);
        System.out.println("反转：" + sb);
    }
}