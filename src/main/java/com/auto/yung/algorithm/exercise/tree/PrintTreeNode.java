package com.auto.yung.algorithm.exercise.tree;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author yungwang
 * @date 2019/7/7.
 * <p>
 * 从上到下打印二叉树
 * </p>
 */
public class PrintTreeNode {

    /**
     * 从上到下打印二叉树 (从左往右)
     *
     * @param root
     */
    public void printTopToBottom(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
            BinaryTreeNode temp = queue.poll();
            System.out.print(temp.getValue() + ",");
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
    }

    /**
     * 从上到下 打印二叉树（从右往左）
     *
     * @param root
     */
    public void printTopToBottomRight(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new ArrayBlockingQueue<BinaryTreeNode>(16);
        queue.add(root);
        while (queue.size() > 0) {
            BinaryTreeNode temp = queue.poll();
            System.out.print(temp.getValue() + ",");
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
        }
    }

    /**
     * 分行从上到下打印二叉树
     *
     * @param root
     */
    public void printChangeLine(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int toBeDeleted = 1;
        int nextLevel = 0;
        while (queue.size() > 0) {
            BinaryTreeNode temp = queue.poll();
            System.out.print(temp.getValue() + " ");
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
                ++nextLevel;
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
                ++nextLevel;
            }
            --toBeDeleted;
            if (toBeDeleted == 0) {
                System.out.println();
                toBeDeleted = nextLevel;
                nextLevel = 0;
            }
        }
    }

    /**
     * 之字型打印二叉树
     *
     * @param root
     */
    public void printZigzag(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode>[] stacks = new Stack[2];
        Stack<BinaryTreeNode> stack = new Stack<>();
        stacks[0] = stack;
        stacks[1] = new Stack<>();
        int current = 0;
        int next = 1;
        stacks[current].push(root);
        while (!stacks[0].isEmpty() || !stacks[1].isEmpty()) {
            BinaryTreeNode temp = stacks[current].peek();
            stacks[current].pop();
            System.out.print(temp.getValue() + " ");
            if (current == 0) {
                if (temp.getLeft() != null) {
                    stacks[next].push(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    stacks[next].push(temp.getRight());
                }
            } else {
                if (temp.getRight() != null) {
                    stacks[next].push(temp.getRight());
                }
                if (temp.getLeft() != null) {
                    stacks[next].push(temp.getLeft());
                }
            }

            if (stacks[current].isEmpty()) {
                System.out.println();
                current = 1 - current;
                next = 1 - next;
            }
        }
    }

    /**
     * 查找路径
     *
     * @param root
     * @param expectedNumber
     */
    public void findPath(BinaryTreeNode root, int expectedNumber) {
        if (root == null) {
            return;
        }
        List<Double> path = new ArrayList<>();
        int currentSum = 0;
        findPath(root, expectedNumber, path, currentSum);
    }

    private void findPath(BinaryTreeNode root, int expectedNumber, List<Double> path, int currentSum) {
        currentSum += root.getValue();
        path.add(root.getValue());
        boolean isLeaf = root.getLeft() == null && root.getRight() == null;
        if (isLeaf && currentSum == expectedNumber) {
            System.out.println("Path is found:");
            for (Double item : path) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        if (root.getLeft() != null) {
            findPath(root.getLeft(), expectedNumber, path, currentSum);
        }
        if (root.getRight() != null) {
            findPath(root.getRight(), expectedNumber, path, currentSum);
        }
        path.remove(path.size() - 1);
    }

    /**
     * 查找路径
     *
     * @param root
     * @param expectedNumber
     */
    public void findPathStack(BinaryTreeNode root, int expectedNumber) {
        if (root == null) {
            return;
        }
        Stack<Double> path = new Stack<>();
        int currentSum = 0;
        findPath(root, expectedNumber, path, currentSum);
    }

    private void findPath(BinaryTreeNode root, int expectedNumber, Stack<Double> path, int currentSum) {
        currentSum += root.getValue();
        path.push(root.getValue());
        boolean isLeaf = root.getLeft() == null && root.getRight() == null;
        if (isLeaf && currentSum == expectedNumber) {
            System.out.println("Path-Stack is found:");
            for (Double item : path) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        if (root.getLeft() != null) {
            findPath(root.getLeft(), expectedNumber, path, currentSum);
        }
        if (root.getRight() != null) {
            findPath(root.getRight(), expectedNumber, path, currentSum);
        }
        path.pop();
    }
}
