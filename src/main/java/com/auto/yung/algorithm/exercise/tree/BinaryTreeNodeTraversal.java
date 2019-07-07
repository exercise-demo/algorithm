package com.auto.yung.algorithm.exercise.tree;

/**
 * @author yungwang
 * @date 2019/7/7.
 */
public class BinaryTreeNodeTraversal {

    /**
     * 打印前序遍历
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

}
