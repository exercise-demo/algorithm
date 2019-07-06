package com.auto.yung.algorithm.exercise.string;

/**
 * @author yungwang
 * @date 2019/7/6.
 */
public class StringPattern {
    /**
     * 正则表达式匹配
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(String str, int strBegin, String pattern, int pattenBegin) {
        if (strBegin >= str.length() || pattenBegin >= pattern.length()) {
            return false;
        }
        if (str.charAt(strBegin) == pattern.charAt(pattenBegin)) {
            return true;
        }

        if (pattern.length() > pattenBegin + 1 && pattern.charAt(pattenBegin + 1) == '*') {
            if (str.charAt(strBegin) == pattern.charAt(pattenBegin)
                    || (pattern.charAt(pattenBegin) == '.' && str.charAt(strBegin) != '\0')) {
                return matchCore(str, strBegin + 1, pattern, pattenBegin + 2)
                        || matchCore(str, strBegin + 1, pattern, pattenBegin)
                        || matchCore(str, strBegin, pattern, pattenBegin);
            } else {
                return matchCore(str, strBegin, pattern, pattenBegin + 2);
            }
        }
        if (pattern.charAt(pattenBegin) == '.') {
            return matchCore(str, strBegin, pattern + 1, pattenBegin + 1);
        }
        return false;
    }
}
