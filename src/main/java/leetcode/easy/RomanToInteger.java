package leetcode.easy;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanToInteger {

    public static void main(String[] args) throws IOException {
        // III -> 3
        // LVIII -> 58
        // MCMXCIV -> 1994
        System.out.println(solution("LVIII"));
    }

    public static int solution(String s) {
        Map<String, Integer> romMap = new HashMap<>();
        romMap.put("I", 1);
        romMap.put("V", 5);
        romMap.put("X", 10);
        romMap.put("L", 50);
        romMap.put("C", 100);
        romMap.put("D", 500);
        romMap.put("M", 1000);

        int length = s.length();

        String[] splitRom = s.split("");

        int result = 0;

        for(int i =0; i<length; i++) {
            if(i < length - 1 && romMap.get(splitRom[i]) < romMap.get(splitRom[i+1]))
                result -= romMap.get(splitRom[i]);
            else
                result += romMap.get(splitRom[i]);
        }

        return result;
    }
}
