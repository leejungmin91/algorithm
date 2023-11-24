package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B9625 {

    static int[] dp9625;

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bufferedReader.readLine());

        dp9625 = new int[size+2];

        dp9625[0] = 0;
        dp9625[1] = 1;
        dp9625[2] = 1;

        int countA = 0;
        int countB = 0;

        int answerA = func9625(size-1);
        int answerB = func9625(size);

        System.out.println(answerA + " " + answerB);
    }

    static int func9625(int k){
        for(int i=2; i<=k; i++){
            dp9625[i] = dp9625[i-1] + dp9625[i-2];
        }

        return dp9625[k];
    }
}