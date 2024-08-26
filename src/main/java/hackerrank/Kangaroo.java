package hackerrank;

import java.util.List;
import java.util.stream.Collectors;

public class Kangaroo {

    public static void main(String[] args) {
        System.out.println(kangaroo(0,3,4,2));
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        int kangaroo1 = x1 + v1; // 0 + 3
        int kangaroo2 = x2 + v2; // 4 + 2

        // 1. 시작 위치에 가까운 캥거루가 멀리있는 캥거루보다 이동거리가 커야함.
        // 절대 따라잡지 못하는 경우
        if(x1 < x2 && v1 <= v2) return "NO";

        // 2. 절대 만나지 못하는 경우
        if(kangaroo1 > kangaroo2) {
            if(kangaroo1%kangaroo2 != 0) return "NO";
        }else {
            if(kangaroo2%kangaroo1 != 0) return "NO";
        }

        return "YES";
    }

}
