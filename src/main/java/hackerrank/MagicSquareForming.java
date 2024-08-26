package hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MagicSquareForming {
    public static void main(String[] args) {
        List<List<Integer>> s = new ArrayList<>();
        List<Integer> s1 = List.of(5,3,4);
        List<Integer> s2 = List.of(1,5,8);
        List<Integer> s3 = List.of(6,4,2);
        s.add(s1);
        s.add(s2);
        s.add(s3);
        formingMagicSquare(s);
    }

    public static int formingMagicSquare(List<List<Integer>> s) {
        // 먼저 배열안에서 가로 세로 대각선의 합중 제일 큰 것을 찾는다.
        // 5 3 4
        // 1 5 8
        // 6 4 2
        // 총 나오는 개수가 8개임.
        // 가로 3개 세로 3개 대각선 2개
        // [0,0], [0,1], [0,2] -> 가로
        // [1,0], [1,1], [1,2] -> 가로
        // [2,0], [2,1], [2,2] -> 가로
        // [0,0], [1,0], [2,0] -> 세로
        // [0,1], [1,1], [2,1] -> 세로
        // [0,2], [1,2], [2,2] -> 세로
        // [0,0], [1,1], [2,2] -> 대각
        // [0,2], [1,1], [2,0] -> 대각
        // 5 부터 시작해서 가로 세로 대각선 찾음 -> 5+3+4
        Set<Integer> maxSumList = new HashSet<>();
        for(int i=0; i<s.size(); i++) {
            // 5 3 4
            // 1 5 8
            // 6 4 2
            int horizontalSum = 0;
            int verticalSum = 0;
            int anotherSum1 = 0;
            int anotherSum2 = 0;
            for(int j=0; j<s.get(i).size(); j++) {
                // 가로 합 구하기
                horizontalSum += s.get(i).get(j);
                // 세로 합 구하기
                verticalSum += s.get(j).get(i);
                // 대각 1
                anotherSum1 += s.get(j).get(j);
                // 대각 2
                anotherSum2 += s.get(j).get(s.size()-1-j);
            }
            maxSumList.add(Math.max(anotherSum2, Math.max(anotherSum1, Math.max(horizontalSum, verticalSum))));
        }

        int max = maxSumList.stream()
                .max(Integer::compare)
                .orElseThrow();



        return 0;
    }
}
