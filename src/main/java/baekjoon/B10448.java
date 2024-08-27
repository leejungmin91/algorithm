package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class B10448 {

    static int[] gauss;	//삼각수 저장 배열
    static boolean[] check;	//삼각수 3개로 표현할 수 있는지 확인 배열
    static List<Integer> questionList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        gauss = new int[45];
        check = new boolean[1001];
        for(int i=1; i<45; i++) {
            gauss[i] = i*(i+1)/2;
        }

        for(int i=1;i<1001;i++)
            search(0, i, i);

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int K = Integer.parseInt(br.readLine());
            questionList.add(K);
        }

        for(int question: questionList) {
            if(check[question])	//삼각수 3개로 표현 가능
                System.out.println("1");
            else		//삼각수 3개로 표현 불가능
                System.out.println("0");
        }
    }

    public static void search(int count, int cur, int index){
        if(count == 3){		//삼각수 3개를 사용했을 때
            if(cur == 0)	//삼각수 3개로 표현 가능할 때
                check[index] = true;
            return;
        }
        if(cur <= 0)	//삼각수 보다 커질 때
            return;
        //사용할 수 있는 삼각수 값들 모든 경우 탐색
        for(int i=1;i<45;i++){
            if(cur < gauss[i])	//더 큰 삼각수일 경우 중단
                break;
            search(count+1, cur - gauss[i], index);
        }
    }

}
