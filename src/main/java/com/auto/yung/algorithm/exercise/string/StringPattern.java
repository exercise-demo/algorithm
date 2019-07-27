package com.auto.yung.algorithm.exercise.string;

import java.util.HashMap;
import java.util.Map;

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

    public String longestSubString(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int[] fx = new int[str.length()];
        fx[0] = 1;
        map.put(str.charAt(0), 0);
        for (int i = 1; i < str.length(); ++i) {
            Character ch = str.charAt(i);
            if (map.containsKey(ch)) {
                int index = map.get(ch);
                if (fx[i - 1] <= i - index) {
                    fx[i] = fx[i - 1] + 1;
                } else {
                    fx[i] = i - index;
                }
            } else {
                fx[i] = fx[i - 1] + 1;
            }
            map.put(ch, i);
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (fx[i] > max) {
                max = fx[i];
                index = i;
            }
        }
        return str.substring(index - max + 1, index + 1);
    }

    public String longestSubString1(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        int[] position = new int[26];
        for (int i = 0; i < 26; ++i) {
            position[i] = -1;
        }

        int max = 0;
        int current = 0;
        int end = 0;
        for (int i = 0; i < str.length(); ++i) {
            int index = position[str.charAt(i) - 'a'];
            if (index < 0 || current <= i - index) {
                current++;
            } else {
                if (current > max) {
                    max = current;
                    end = i;
                }
                current = i - index;
            }
            position[str.charAt(i) - 'a'] = i;
        }
        if (current > max) {
            max = current;
            end = str.length();
        }
        return str.substring(end - max, end);
    }
}
