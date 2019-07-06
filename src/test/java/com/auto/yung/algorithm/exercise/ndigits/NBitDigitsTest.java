package com.auto.yung.algorithm.exercise.ndigits;

import org.junit.Test;

/**
 * @author yungwang
 * @date 2019/6/30.
 */
public class NBitDigitsTest {

    private NBitDigits nBitDigits = new NBitDigits();

    @Test
    public void print1ToMaxOfNDigits() throws Exception {
        nBitDigits.print1ToMaxOfNDigits(3);
    }

    @Test
    public void print1ToMaxOfNDigitsDfs() {
        nBitDigits.print1ToMaxOfDigitsDfs(3);
    }

}