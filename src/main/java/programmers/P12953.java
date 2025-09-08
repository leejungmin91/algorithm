package programmers;

public class P12953 {
    public int solution(int[] arr) {
        /*
        두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
        예를 들어 2와 7의 최소공배수는 14가 됩니다.
        정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
        n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
         */
        /*
        [2,6,8,14]	168
        [1,2,3]	6
         */
        int answer = 0;
        int a = 2;
        int b = 7;

        // 최소공배수

        return lcm(a, b);
    }

    public int gcd(int a, int b) {
        if(a == 0 ) return b;
        if(b == 0 ) return a;
        return gcd(b, a%b);
    }

    public int lcm(int[] arr) {
        int l = 1;
        for(int a : arr) {
            l = lcm(l, a);
            if(l == 0) return 0;
        }
        return l;
    }

    public int lcm(int a, int b) {
        if(a == 0 || b == 0) return 0;
        int g = gcd(a, b);
        return (a / g) * b;
    }

    public static void main(String[] args){
        int[] arr = {2,6,8,14};
        int answer = new P12953().solution(arr);
        System.out.println(answer);
    }
}
