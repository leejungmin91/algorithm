package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class DrawingBook {

    static int[][] book;

    public static void main(String[] args) {
        System.out.println(pageCount(5,4));
    }

    public static int pageCount(int n, int p) {

        // 현재 페이지 위치
        // n : 6, p : 2, last : 4, search : 2
        // n : 5, p : 4, last : 3, search : 3
        int count = 0;
        int lastPage = (n/2 + 1);
        int searchPage = (p/2 + 1);

        if(lastPage > searchPage) count = searchPage;
        else count = lastPage;

        return Math.abs(lastPage-searchPage) ;
    }
}
