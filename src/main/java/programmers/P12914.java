package programmers;

public class P12914 {
    public long solution(int n) {
        long[] dp = new long[n+1];
        long answer = 0;

        // 1,2,3,5,8,13
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n]%1234567;
    }
}
