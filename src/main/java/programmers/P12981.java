package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P12981 {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        used.add(words[0]);

        char c = words[0].charAt(words[0].length() - 1);

        for (int i = 1; i < words.length; i++) {
            // 앞 단어의 마지막 문자와 현재 단어의 첫 문자가 다르거나, 중복 단어일 경우
            if (words[i].charAt(0) != c || !used.add(words[i])) {
                return new int[] {i % n + 1, i / n + 1};
            }
            c = words[i].charAt(words[i].length() - 1);
        }

        // 탈락자 없음
        return new int[] {0, 0};
    }

    public static void main(String[] args){
        int n = 2;
        String[] words = {"tank", "tank"};
        int[] answer = new P12981().solution(n, words);
        System.out.println(answer[0] + " " + answer[1]);
    }
}
