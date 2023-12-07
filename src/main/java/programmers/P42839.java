package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P42839 {

    public static void main(String[] args){

        String numbers = "17";

        String[] stra = numbers.split("");
        int[] arr = new int[numbers.length()];
////
        for(int i=0; i< stra.length; i++){
            arr[i] = Integer.parseInt(stra[i]);
        }

    }

}
