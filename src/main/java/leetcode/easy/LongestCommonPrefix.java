package leetcode.easy;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestCommonPrefix {

    public static void main(String[] args) throws IOException {
        // strs = ["flower","flow","flight"] -> "fl"
        String[] strs = {"flower", "fkow"};
        System.out.println(solution(strs));
    }

    public static String solution(String[] strs) {

        /**
         *  1. kaflower, kbflow, kcflight -> k
         *  2. for 문을 돌려서 첫번째 문자부터 같은지 확인을 함.
         */

        int size = strs[0].length();
        for(String str : strs) {
            size = Math.min(size, str.length());
        }

        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char currentChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != currentChar) {
                    return prefix.toString();
                }
            }
            prefix.append(currentChar);
        }

        return prefix.toString();
    }
}
