package programmers;

import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class P131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        int needKinds = want.length;
        Map<String, Integer> need = new HashMap<>();
        for (int i = 0; i < needKinds; i++) need.put(want[i], number[i]);

        // 현재 10일 창의 품목 카운트
        Map<String, Integer> have = new HashMap<>();
        int n = discount.length;
        if (n < 10) return 0;

        // 초기 10일 채우기
        for (int i = 0; i < 10; i++) {
            have.put(discount[i], have.getOrDefault(discount[i], 0) + 1);
        }

        int answer = 0;
        // 창을 왼쪽→오른쪽으로 이동하며 매번 비교
        for (int start = 0; start + 9 < n; start++) {
            if (matches(need, have)) answer++;

            // 다음 창으로 이동: start에서 나가는 1개 제거, start+10 들어오는 1개 추가
            if (start + 10 < n) {
                String out = discount[start];
                int cnt = have.get(out) - 1;
                if (cnt == 0) have.remove(out);
                else have.put(out, cnt);

                String in = discount[start + 10];
                have.put(in, have.getOrDefault(in, 0) + 1);
            }
        }
        return answer;
    }

    // want의 모든 품목 수량이 현재 10일 창과 정확히 일치하는지
    // (number 합이 10이라 >= 대신 ==로 검사해도 무방)

    private boolean matches(Map<String, Integer> need, Map<String, Integer> have) {
        for (Map.Entry<String, Integer> e : need.entrySet()) {
            if (have.getOrDefault(e.getKey(), 0) < e.getValue()) return false; // <= 여기를 >= 비교로
        }
        return true;
    }

    public static void main(String[] args) {
        P131127 s = new P131127();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {
                "chicken","apple","apple","banana","rice","apple",
                "pork","banana","pork","rice","pot","banana","apple","banana"
        };
        System.out.println(s.solution(want, number, discount)); // 3
    }
}
