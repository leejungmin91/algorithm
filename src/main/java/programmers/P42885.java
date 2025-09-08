package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P42885 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;                    // 가장 가벼운 쪽 포인터
        int j = people.length - 1;    // 가장 무거운 쪽 포인터
        int boats = 0;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;                  // 같이 탈 수 있으면 가벼운 사람 태움
            }
            j--;                      // 무거운 사람은 항상 태움 (혼자 or 짝과 함께)
            boats++;                  // 보트 1대 사용
        }
        return boats;
    }
}
