package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P12941 {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        Arrays.sort(A);
        Arrays.sort(B);

        int length = A.length;
        int multiple = 0;
        int sum = 0;

        for(int i=0; i<length; i++) {
            multiple = A[i] * B[length-i-1];
            sum += multiple;
        }

        return sum;
    }
}
