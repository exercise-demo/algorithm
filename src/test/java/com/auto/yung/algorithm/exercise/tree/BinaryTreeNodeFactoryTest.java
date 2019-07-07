package com.auto.yung.algorithm.exercise.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yungwang
 * @date 2019/7/7.
 */
public class BinaryTreeNodeFactoryTest {

    int[] preOrder = new int[] {1,2,4,7,3,5,6,8};
    int[] inOrder = new int[] {4,7,2,1,5,3,8,6};

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() throws Exception {
        BinaryTreeNode treeNode = BinaryTreeNodeFactory.create(preOrder,inOrder);
    }

}