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
     * 查找链表中倒数第k个节点
     *
     * @param root
     * @param k
     * @return
     */
    public LinkNode findKthToTail(LinkNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }
        LinkNode firstNode = root;
        LinkNode secondNode = root;
        for (int i = 0; i < k - 1; ++i) {
            if (firstNode.getNext() != null) {
                firstNode = firstNode.getNext();
            } else {
                return null;
            }
        }
        while (firstNode.getNext() != null) {
            firstNode = firstNode.getNext();
            secondNode = secondNode.getNext();
        }
        return secondNode;
    }

    /**
     * 链表反转
     *
     * @param node
     * @return
     */
    public LinkNode reverseList(LinkNode node) {
        if (node == null) {
            return null;
        }
        LinkNode preNode = null;
        LinkNode curNode = node;
        LinkNode nextNode = curNode.getNext();
        while (nextNode != null) {
            curNode.setNext(preNode);
            preNode = curNode;
            curNode = nextNode;
            nextNode = curNode.getNext();
        }
        curNode.setNext(preNode);

        return curNode;
    }

    /**
     * 两两翻转链表
     *
     * @param node
     * @return
     */
    public LinkNode twoReverseList(LinkNode node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        LinkNode pre = null;
        LinkNode cur = node;
        LinkNode res = cur.getNext();
        LinkNode nextNext;
        while (cur != null && cur.getNext() != null) {
            nextNext = cur.getNext().getNext();
            cur.getNext().setNext(cur);
            if (pre != null) {
                pre.setNext(cur.getNext());
            }
            cur.setNext(nextNext);

            pre = cur;
            cur = cur.getNext();
        }
        return res;
    }

    /**
     * 合并两个排序的链表
     *
     * @param node1
     * @param node2
     * @return
     */
    public LinkNode merge(LinkNode node1, LinkNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        LinkNode pNode = null;
        if (node1.getValue() < node2.getValue()) {
            pNode = node1;
            pNode.setNext(merge(node1.getNext(), node2));
        } else {
            pNode = node2;
            pNode.setNext(merge(node1, node2.getNext()));
        }
        return pNode;
    }

    /**
     * 删除 重复节点
     *
     * @return
     */
    public LinkNode deleteDuplicateNode(LinkNode root) {
        if (root == null) {
            return null;
        }
        LinkNode pNode = root;
        LinkNode preNode = null;
        while (pNode != null) {
            LinkNode pNext = pNode.getNext();
            boolean needDeleted = false;
            if (pNext != null && pNode.getValue() == pNext.getValue()) {
                needDeleted = true;
            }
            if (!needDeleted) {
                preNode = pNode;
                pNode = pNode.getNext();
            } else {
                int value = pNode.getValue();
                LinkNode toBeDelete = pNode;
                while (toBeDelete.getValue() == value) {
                    pNext = toBeDelete.getNext();
                    toBeDelete.setNext(null);
                    toBeDelete = pNext;
                }
                if (preNode != null) {
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
