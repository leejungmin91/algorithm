package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class DrawingBook {

    static int[][] book;

    public static void main(String[] args) {
        System.out.println(pageCount(7,4));
    }

    public static int pageCount(int n, int p) {

        // 현재 페이지 위치
        // n : 6, p : 2, last : 4, search : 2, ans : 1, f : 1, b : 3
        // n : 5, p : 4, last : 3, search : 3, ans : 0, f : 2, b : 0
        // n : 4, p : 4, last : 3, search : 3, ans : 0, f : 2, b : 0
        // n : 7, p : 4, last : 4, search : 3, ans : 1, f : 1, b : 1
        // n : 6, p : 4, last : 4, search : 3, ans : 1, f : 2, b : 1
        // 앞으로가는게 빠른경우
        // 뒤로가는게 빠른경우
        // 두개를 나누는 경우는
        // 0 1 | 0
        // 2 3 | 1
        // 4 5 | 2
        // 6 7 | 3
        int count = 0;
        int lastPage = (n/2 + 1);
        int searchPage = (p/2 + 1);

        int frontCount = searchPage - 1;
        int backCount = lastPage - searchPage;

        return Math.min(frontCount, backCount);
    }
}
