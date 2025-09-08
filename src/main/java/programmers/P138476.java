package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P138476 {
    public int solution(int k, int[] tangerine) {
        int answer = 1;

        Map<Integer, Integer> map = new HashMap<>();

        for (int j : tangerine) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        int sum = 0;

        List<Integer> countList = new ArrayList<>(map.values());

        countList.sort((o1, o2) -> o2 - o1);

        for(int count : countList){
            sum += count;
            if(sum < k){
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        int k = 2;
        int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};
        int answer = new P138476().solution(k, tangerine);
        System.out.println(answer);
    }
}
