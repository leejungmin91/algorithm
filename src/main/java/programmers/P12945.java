package programmers;

public class P12945 {

    public static int solution(int n) {

        final int divideValue = 1234567;

        int[] dp = new int[n+1];
        dp[0] = 0%divideValue;
        dp[1] = 1%divideValue;
        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2])%divideValue;
        }

        int answer = dp[n];
        return answer;
    }

    public static void main(String[] args){
        int n = solution(78);
        System.out.println(n);
    }

}
