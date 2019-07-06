package com.auto.yung.algorithm.exercise.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yungwang
 * @date 2019/7/6.
 */
public class StringPatternTest {
    private StringPattern stringPattern;
    @Before
    public void setUp() throws Exception {
        stringPattern = new StringPattern();
    }

    @Test
    public void match1() throws Exception {
        boolean flag = stringPattern.match("aaa","ab*a");
        System.out.println(flag);
    }

    @Test
    public void match2() throws Exception {
        boolean flag = stringPattern.match("aaa","ab*ac*a");
        System.out.println(flag);
    }

}