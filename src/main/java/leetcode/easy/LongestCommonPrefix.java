package leetcode.easy;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestCommonPrefix {

    public static void main(String[] args) throws IOException {
        // strs = ["flower","flow","flight"] -> "fl"
        // LVIII -> 58
        // MCMXCIV -> 1994
        List<String> strs = List.of("kaflower","kbflow","kcflight");
        System.out.println(solution(strs));
    }

    public static String solution(List<String> strs) {
        String[] arr1 = strs.get(0).split("");
        String[] arr2 = strs.get(1).split("");
        String[] arr3 = strs.get(2).split("");

        int size = Math.min(Math.min(arr1.length, arr2.length), arr3.length);

        List<String> resultList = new ArrayList<>();
        String result = "";

        for(int i=0; i<size; i++) {
            if(arr1[i].equals(arr2[i]) && arr1[i].equals(arr3[i])) {
                result += arr1[i];
            } else {
                result += "&";
            }
        }

        // k&fl&&

        String[] splitResult = result.split("&");
        int maxLength = 0;
        int index = 0;
        for(int i=0; i<splitResult.length; i++) {
            if(maxLength < splitResult[i].length()) {
                maxLength = splitResult[i].length();
                index = i;
            }
        }

        String res = splitResult[index];

        System.out.println(res);

        return null;
        //return result;
    }
}
