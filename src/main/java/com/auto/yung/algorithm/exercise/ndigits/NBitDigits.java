package com.auto.yung.algorithm.exercise.ndigits;

/**
 * @author yungwang
 * @date 2019/6/30.
 */
public class NBitDigits {

    /**
     * 打印从1 到最大的n位数
     *
     * @param n
     */
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }

        while (!increment(number)) {
            printNumber(number);
        }
    }

    /**
     * 递归方式实现 从1到最大n位打印
     *
     * @param n
     */
    public void print1ToMaxOfDigitsDfs(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];

        print1ToMaxOfNDigitsRecursively(number,n,0);
    }

    private void print1ToMaxOfNDigitsRecursively(char[] numbers, int length, int index) {
        if (index == length) {
            printNumber(numbers);
            return;
        }
        for (int i = 0; i < 10; i++) {
            numbers[index] = getCharByInt(i);
            print1ToMaxOfNDigitsRecursively(numbers, length, index + 1);
        }
    }

    private boolean increment(char[] number) {
        boolean isOverFlow = false;
        int nTakeOver = 0;
        int length = number.length;
        for (int i = length - 1; i >= 0; --i) {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == length - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    nTakeOver = 1;
                    nSum %= 10;
                    number[i] = getCharByInt(nSum);
                }
            } else {
                number[i] = getCharByInt(nSum);
                break;
            }
        }
        return isOverFlow;
    }

    private char getCharByInt(int nSum) {
        String s = String.valueOf(nSum);
        char c = s.charAt(0);
        return c;
    }

    private void printNumber(char[] number) {
        boolean isBeginning = true;
        int length = number.length;
        for (int i = 0; i < length; i++) {
            if (isBeginning && number[i] != '0') {
                isBeginning = false;
            }
            if (!isBeginning) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }
}
