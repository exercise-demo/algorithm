package com.auto.yung.algorithm.exercise.linklist;

/**
 * @author yungwang
 * @date 2019/7/6.
 */
public class LinkListFactory {

    /**
     * 创建单向链表
     *
     * @param array
     * @return
     */
    public static LinkNode createLinkList(int[] array) {
        if (array == null) {
            return null;
        }
        LinkNode root = null;
        for (int item : array) {
            root = create(root, item);
        }
        return root;
    }

    public static LinkNode findValue(LinkNode node,int value) {
        if(node == null) {
            return null;
        }
        LinkNode pNode = node;
        while(pNode != null && pNode.getValue() != value) {
            pNode = pNode.getNext();
        }
        return pNode;
    }

    /**
     * 在最后一个位置插入node节点
     *
     * @param root
     * @param value
     * @return
     */
    private static LinkNode create(LinkNode root, int value) {
        LinkNode node = new LinkNode();
        node.setValue(value);
        node.setNext(null);
        if (root == null) {
            root = node;
        } else {
            LinkNode temp = root;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
        return root;
    }
}

