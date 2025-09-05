package programmers;

import java.util.ArrayList;
import java.util.List;

public class P42842 {
    public int[] solution(int brown, int yellow) {
        int sumTile = brown + yellow;
        List<Integer> verticalArr = new ArrayList<>();
        List<Integer> horizontalArr = new ArrayList<>();

        // sumTile 의 약수
        for(int i=1; i<sumTile; i++){
            // 약수
            if(sumTile % i == 0){
                verticalArr.add(sumTile/i);
                horizontalArr.add(i);
            }
        }

        int vertical = verticalArr.get(verticalArr.size()/2);
        int horizontal = horizontalArr.get(horizontalArr.size()/2);
        int[] answer = {vertical, horizontal};

        if(vertical < horizontal) answer = new int[]{horizontal, vertical};

        return answer;
    }
}
