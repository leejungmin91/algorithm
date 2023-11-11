package programmers;

import java.util.Arrays;

public class P120956 {

    public static void main(String[] args){
        String babbling[] = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};

        String canBabble[] = {"aya", "ye", "woo", "ma"};

        Arrays.sort(babbling);
        Arrays.sort(canBabble);

        int count = 0;

        for(String bb : babbling){
            StringBuilder str = new StringBuilder();
            for(String cb : canBabble){
                if(bb.contains(cb)) {
                    str.append(cb);
                }
            }
            char[] charArr = str.toString().toCharArray();
            char[] charArr2 = bb.toCharArray();
            Arrays.sort(charArr);
            Arrays.sort(charArr2);
            if(new String(charArr2).equals(new String(charArr))) count++;
        }

        System.out.println(count);


    }

}
