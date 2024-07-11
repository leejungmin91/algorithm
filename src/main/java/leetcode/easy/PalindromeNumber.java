package leetcode.easy;

import java.io.IOException;

public class PalindromeNumber {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(0));
    }

    public static boolean solution(long x) {
        // 1. 배열로 하나씩 담는다.
        // 2. 첫번째랑 마지막 비교한다.
        // 3. 길이가 홀수이면 마지막은 자기자신과 비교한다.
        if(x < 0) return false;

        int length = x == 0 ? 1 : (int)( Math.log10(Math.abs(x))+1 );

        if(length == 1) return true;

        long[] arr = new long[length];

        long temp = x;

        for(int i=length; i>0; i--){
            // 자리수 3자리 -> 10^(3-1) => 100
            // 223/100 = 몫 2 나머지 23
            double div = Math.pow(10, i-1);
            int num = (int) (temp/div);
            temp = (long) (temp%div);
            arr[length-i] = num;
        }

        boolean isPalindrome = true;

        // 1. 만약 짝수이면? -> 4자리이면 2번만 돌리고 1=4 2=3 비교
        // 2. 만약 홀수이면? -> 5자리이면 3번돌리고 1=5 2=4 3=3

        for(int i=0; i<Math.ceil(length/2.0); i++){
            if (arr[i] != arr[length - i - 1]) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }
}
