package programmers;

public class P12980 {
    public int solution(int n) {
        int ans = 0;

        if(n == 1) return 1;

        int i = 1;

        while(n > 0){
            if(n < (int)Math.pow(2, i)) {
                int pow = (int)Math.pow(2, i-1);
                n = n - pow;
                ans++;
                i = 1;
            }
            i++;
        }

        // 위에도 정답은 맞으나, 쉽게 푸는 방법
        // 결국은 2진법이기 때문에
        // return Integer.bitCount(n);

        return ans;
    }
}
