package com.auto.yung.algorithm.exercise.tree;

/**
 * @author yungwang
 * @date 2019/7/7.
 */
public class BinaryTreeNode {

    private double value;
    /**
     * 左节点
     */
    private BinaryTreeNode left;
    /**
     * 右节点
     */
    private BinaryTreeNode right;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
