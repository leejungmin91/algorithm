package leetcode.easy;

import java.io.IOException;
import java.util.Arrays;

public class ValidParentheses {

    public static void main(String[] args) throws IOException {
        // strs = ["flower","flow","flight"] -> "fl"
        String s = "[]()";
        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        /**
         *  1. () -> true, (] -> false, ([]) -> true, ()[]{} -> true
         *  그냥 (), [], {} 계속 제거하면 될거같은데..
         *  1. {([])} -> {()} -> {} -> true
         *  2. []({}) -> () -> true
         *  3. ((())) -> (()) -> () -> true
         *
         */
        String[] open = {"(", "[", "{"};
        String[] splitS = s.split("");

        boolean isValid = false;

        int size = s.length();

        // 짝수가 맞는가?
        if(size%2 != 0) return false;

        // 열림으로 시작했는가?
        if(Arrays.stream(open).noneMatch(o -> o.equals(splitS[0]))) return false;

        for(int i=0; i<size/2; i++) {
            s = s.replaceAll("\\(\\)", "");
            s = s.replaceAll("\\[\\]", "");
            s = s.replaceAll("\\{\\}", "");
            if(s.length() == 0) return true;
        }

        return isValid;
    }
}
