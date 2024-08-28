package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B11722 {

    private static int[] dp;
    private static int[] A;
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        A = new int[n];
        dp = new int[n];

        for(int i=0; i<n; i++) {
            A[i] = sc.nextInt();
            dp[i] = 1;
        }

        // 6
        // 10 30 10 20 20 10

        decrease();
        System.out.println(result);
    }

    private static void decrease() {
        for(int i=0;i<A.length;i++) { //기준값
            for(int j=0;j<i;j++) { //이전값들
                if(A[j] > A[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            result = Math.max(result, dp[i]);
        }
    }

    /*private static void decrease(int index, int maxCount) {
        if(A.length <= index+1) {
            count = Math.max(count, maxCount);
            return;
        }
        if(A[index] > A[index+1]) {
            count++;
        } else {
            count = 0;
        }
        decrease(index+1, count);
    }*/

}
