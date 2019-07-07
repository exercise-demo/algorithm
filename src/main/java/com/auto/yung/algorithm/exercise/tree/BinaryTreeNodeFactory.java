package com.auto.yung.algorithm.exercise.tree;

/**
 * @author yungwang
 * @date 2019/7/7.
 */
public class BinaryTreeNodeFactory {

    /**
     * 根据前序和中序遍历创建二叉树
     * 前序和后序不含重复的数字
     *
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static BinaryTreeNode create(int[] preOrder, int[] inOrder) {
        if (preOrder == null || preOrder.length == 0) {
            return null;
        }
        if (inOrder == null || inOrder.length == 0) {
            return null;
        }
        return createCore(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    private static BinaryTreeNode createCore(int[] preOrder, int preStart, int preEnd,
                                             int[] inOrder, int inStart, int inEnd) {
        int rootValue = preOrder[preStart];
        BinaryTreeNode rootNode = new BinaryTreeNode();
        rootNode.setValue(rootValue);
        int leftLength = 0;
        if (preOrder[preStart] == preOrder[preEnd] && inOrder[inStart] == inOrder[inEnd]
                && preOrder[preStart] == inOrder[inStart]) {
            return rootNode;
        }
        while (inStart + leftLength <= inEnd && inOrder[inStart + leftLength] != rootValue) {
            ++leftLength;
        }
        if (leftLength == inEnd && inOrder[leftLength] != rootValue) {
            return null;
        }

        if (leftLength > 0) {
            rootNode.setLeft(createCore(preOrder, preStart + 1, preStart + leftLength,
                    inOrder, inStart, inStart + leftLength - 1));
        }
        if (leftLength < preEnd - preStart) {
            rootNode.setRight(createCore(preOrder, preStart + leftLength + 1, preEnd,
                    inOrder, inStart + leftLength + 1, inEnd));
        }

        return rootNode;
    }
}
