package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P12909 {
    boolean solution(String s) {
        boolean answer = true;

        String[] splitString = s.split("");
        if(!splitString[0].equals("(") || !splitString[splitString.length-1].equals(")")){
            return false;
        }

        if(splitString.length%2 != 0) return false;

        int count = 0;

        for(String str : splitString){
            if(str.equals("(")){
                count++;
            }
            if(str.equals(")")){
                count--;
            }
            if(count < 0) return false;
        }

        return count == 0;
    }
}
