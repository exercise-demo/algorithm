package com.auto.yung.algorithm.exercise.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yungwang
 * @date 2019/7/7.
 */
public class PrintTreeNodeTest {
    int[] preOrder = new int[] {1,2,4,7,3,5,6,8};
    int[] inOrder = new int[] {4,7,2,1,5,3,8,6};
    private BinaryTreeNode root;
    private PrintTreeNode printTreeNode;

    @Before
    public void setUp() throws Exception {
        printTreeNode = new PrintTreeNode();
        root = BinaryTreeNodeFactory.create(preOrder,inOrder);
    }

    @Test
    public void printTopToBottom() throws Exception {
        printTreeNode.printTopToBottom(root);
        System.out.println();
        printTreeNode.printTopToBottomRight(root);
        System.out.println();
        printTreeNode.printChangeLine(root);
        System.out.println("之字形打印二叉树：");
        printTreeNode.printZigzag(root);
        printTreeNode.findPath(root,18);
        printTreeNode.findPathStack(root,18);
    }
}