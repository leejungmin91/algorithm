package programmers;

import java.util.Arrays;

public class P12951 {
    public String solution(String s) {

        if (s == null || s.isEmpty() || s.length() > 200) {
            return s;
        }

        s = s.toLowerCase();

        String[] splitS = s.split("");

        boolean isChange = false;

        for(int i=0; i<splitS.length; i++) {
            if(!splitS[i].equals(" ") && !isChange) {
                splitS[i] = splitS[i].toUpperCase();
                isChange = true;
            }

            if(splitS[i].equals(" ")) isChange = false;
        }

        return String.join("", splitS);

    }
}
