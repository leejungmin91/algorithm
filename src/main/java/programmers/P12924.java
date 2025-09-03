package programmers;

public class P12924 {

    public int solution(int n) {

        int cnt = 0;
        for(int i=1; i<=n/2+2; i++){
            if(sum(i, n)) cnt++;
        }

        int answer = cnt+1;

        return answer;
    }

    public boolean sum(int start, int n) {
        int sum = 0;
        for(int i=start; i<=n/2+2; i++){
            if(sum >= n) {
                return sum == n;
            }
            sum += i;
        }

        return false;
    }

}
