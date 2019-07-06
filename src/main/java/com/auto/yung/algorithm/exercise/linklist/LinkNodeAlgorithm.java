package com.auto.yung.algorithm.exercise.linklist;

/**
 * @author yungwang
 * @date 2019/7/6.
 */
public class LinkNodeAlgorithm {

    /**
     * 在O（1）时间内删除链表节点
     */
    public LinkNode deleteNode(LinkNode root, LinkNode toBeDeleted) {
        if (root == null || toBeDeleted == null) {
            return null;
        }

        // 要删除的节点不是尾节点
        if (toBeDeleted.getNext() != null) {
            LinkNode next = toBeDeleted.getNext();
            toBeDeleted.setValue(next.getValue());
            toBeDeleted.setNext(next.getNext());
            next.setNext(null);
        }
        // 链表只有一个节点，删除头节点（也是尾节点）
        else if (root == toBeDeleted) {
            root = null;
        } else {
            LinkNode pNode = root;
            while (pNode.getNext() != toBeDeleted) {
                pNode = pNode.getNext();
            }
            pNode.setNext(null);
        }
        return root;
    }

    /**
     * 删除 重复节点
     * @return
     */
    public LinkNode deleteDuplicateNode(LinkNode root) {
        if(root == null) {
            return null;
        }
        LinkNode pNode = root;
        LinkNode preNode = null;
        while(pNode != null) {
            LinkNode pNext = pNode.getNext();
            boolean needDeleted = false;
            if(pNext != null && pNode.getValue() == pNext.getValue()) {
                needDeleted = true;
            }
            if(!needDeleted) {
                preNode = pNode;
                pNode = pNode.getNext();
            } else {
                int value = pNode.getValue();
                LinkNode toBeDelete = pNode;
                while(toBeDelete.getValue() == value) {
                    pNext = toBeDelete.getNext();
                    toBeDelete.setNext(null);
                    toBeDelete = pNext;
                }
                if(preNode != null) {
                    preNode.setNext(pNext);
                } else {
                    root = pNext;
                }
                pNode = pNext;
            }
        }
        return root;
    }

    public void printNode(LinkNode node) {
        if (node == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        LinkNode pNode = node;
        while (pNode.getNext() != null) {
            sb.append(pNode.getValue());
            if (sb.length() > 0) {
                sb.append(",");
            }
            pNode = pNode.getNext();
        }
        sb.append(pNode.getValue());
        System.out.println(sb.toString());
    }
}
