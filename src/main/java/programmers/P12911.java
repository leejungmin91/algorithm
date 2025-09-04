package programmers;

public class P12911 {

    public static int solution(int n) {
        int i = 1;
        int answer = 0;

        while(true) {
            if(Integer.bitCount(n) == Integer.bitCount(n+i)) {
                answer = n+i;
                break;
            }
            i++;
        }
        return answer;
    }

    public static void main(String[] args){
        int n = solution(78);
        System.out.println(n);
    }

}
