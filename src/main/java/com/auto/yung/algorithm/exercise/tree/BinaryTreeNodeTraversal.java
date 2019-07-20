package com.auto.yung.algorithm.exercise.tree;

import java.util.Stack;

/**
 * @author yungwang
 * @date 2019/7/7.
 */
public class BinaryTreeNodeTraversal {

    /**
     * 打印前序遍历(递归实现)
     *
     * @param root
     * @return
     */
    public String printPreOrder(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.getValue());
        String leftStr = printPreOrder(root.getLeft());
        if (leftStr != null) {
            sb.append(",").append(leftStr);
        }
        String rightStr = printPreOrder(root.getRight());
        if (rightStr != null) {
            sb.append(",").append(rightStr);
        }
        return sb.toString();
    }

    /**
     * 非递归实现
     *
     * @param root
     * @return
     */
    public String printPreOrderR(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            BinaryTreeNode temp = stack.pop();
            sb.append(temp.getValue()).append(",");
            if (temp.getRight() != null) {
                stack.push(temp.getRight());
            }
            if (temp.getLeft() != null) {
                stack.push(temp.getLeft());
            }
        }
        return sb.toString();
    }

    /**
     * 非递归 前序遍历
     *
     * @param root
     * @return
     */
    public String printPreOrderR2(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode p = root;
        StringBuilder sb = new StringBuilder();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                sb.append(p.getValue()).append(",");
                p = p.getLeft();
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.getRight();
            }
        }
        return sb.toString();
    }

    /**
     * 打印后序遍历
     *
     * @param root
     * @return
     */
    public String printPostOrder(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String leftStr = printPostOrder(root.getLeft());
        if (leftStr != null) {
            sb.append(leftStr);
        }
        String rightStr = printPostOrder(root.getRight());
        if (rightStr != null) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(rightStr);
        }
        if (sb.length() > 0) {
            sb.append(",");
        }
        sb.append(root.getValue());
        return sb.toString();
    }

    /**
     * 非递归 中序遍历
     *
     * @param root
     * @return
     */
    public String printInOrderR(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode p = root;
        Stack<BinaryTreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.getLeft();
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                sb.append(p.getValue()).append(",");
                p = p.getRight();
            }
        }
        return sb.toString();
    }

    /**
     * 打印中序遍历
     *
     * @param root
     * @return
     */
    public String printInOrder(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        String leftStr = printInOrder(root.getLeft());
        if (leftStr != null) {
            sb.append(leftStr).append(",");
        }
        sb.append(root.getValue());
        String rightStr = printInOrder(root.getRight());
        if (rightStr != null) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(rightStr);
        }

        return sb.toString();
    }

    /**
     * 非递归 后序遍历(难点)
     *
     * @param root
     * @return
     */
    public String printPostOrderR(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        Stack<BinaryTreeNode> output = new Stack<>();
        StringBuilder sb = new StringBuilder();
        BinaryTreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                output.push(p);
                p = p.getRight();
            } else {
                p = stack.pop();
                p = p.getLeft();
            }
        }
        while (!output.isEmpty()) {
            p = output.pop();
            sb.append(p.getValue()).append(",");
        }
        return sb.toString();
    }

    /**
     * 二叉树反转（镜像）
     *
     * @param root
     * @return
     */
    public BinaryTreeNode reverse(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        BinaryTreeNode temp = root.getLeft();
        root.setLeft(reverse(root.getRight()));
        root.setRight(reverse(temp));

        return root;
    }

    public BinaryTreeNode reverseNotR(BinaryTreeNode root) {
        if(root == null) {
            return null;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            BinaryTreeNode temp = stack.pop();
            BinaryTreeNode left = temp.getLeft();
            BinaryTreeNode right = temp.getRight();
            if(left != null) {
                stack.push(left);
            }
            if(right != null ){
                stack.push(right);
            }
            temp.setRight(left);
            temp.setLeft(right);
        }
        return root;
    }

    /**
     * 第k个位置的节点
     *
     * @param root
     * @return
     */
    public BinaryTreeNode kthNode(BinaryTreeNode root,int k) {
        if(root == null || k == 0) {
            return null;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while(p != null) {
                stack.push(p);
                p = p.getLeft();
            }
            if(!stack.isEmpty()) {
                p = stack.pop();
                k--;
                if(k == 0) {
                    break;
                }
                p = p.getRight();
            }
        }
        return p;
    }

}
