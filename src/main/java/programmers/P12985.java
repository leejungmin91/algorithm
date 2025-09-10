package programmers;

public class P12985 {
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        while(n > 2){
            if(a%2 == 1 && a+1 == b) break;
            a = Math.round((float) a /2);
            b = Math.round((float) b /2);
            n /= 2;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        int n = 8;
        int a = 4;
        int b = 6;
        int answer = new P12985().solution(n, a, b);
        System.out.println(answer);
    }

}
