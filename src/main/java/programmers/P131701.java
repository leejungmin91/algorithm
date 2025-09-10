package programmers;

import java.util.*;

public class P131701 {
    public int solution(int[] elements) {
        int answer = 0;

        // 7 9 1 1 4
        // 1 4 7 9
        // 2 5 10 11 16
        // 6 11 12 17 20
        // 13 15 18 21
        // 22
        // 1 2 4 5 6 7 9 10 11 12 13 15 16 17 18 20 21 22 -> 18


        Set<Integer> answerSet = new HashSet<>();

        int n = elements.length;

        int[] range = new int[2*n];
        // 7 9 1 1 4 7 9 1 1 4
        for(int i = 0; i < 2*n; i++){
            range[i] = elements[i%n];
        }

        int[] psum = new int[2*n];
        // sum 은 1-10까지 들어감 0은 비어있음
        for(int i = 1; i < 2*n; i++){
            psum[i] = psum[i-1] + range[i-1];
        }

        System.out.println(Arrays.toString(psum));

        for (int len = 1; len <= n; len++) {
            for (int start = 0; start < n; start++) {
                int sum = psum[start + len] - psum[start];
                answerSet.add(sum);
            }
        }

        System.out.println(answerSet);

        answer = answerSet.size()-1;

        return answer;
    }

    public static void main(String[] args) {
        P131701  p = new P131701();
        p.solution(new int[] {7, 9, 1, 1, 4});

    }
}
