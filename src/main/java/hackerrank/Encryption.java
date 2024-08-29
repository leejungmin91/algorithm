package hackerrank;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Encryption {

    public static void main(String[] args) {
        encryption("feedthedog");
    }

    public static String encryption(String s) {
        String trim = s.trim();
        int length = trim.length();

        double root = Math.sqrt(length);
        int rowCnt = (int) Math.ceil(root);

        List<List<String>> list = new ArrayList<>();
        String[] splitString = s.split("");

        for(int i=0; i<rowCnt; i++) {
            List<String> strings = new ArrayList<>();
            for(int j=0; j<rowCnt; j++) {
                if(length <= j+(rowCnt)*i) break;
                else strings.add(splitString[j+(rowCnt)*i]);
            }
            if(!strings.isEmpty()) list.add(strings);
        }

        System.out.println(list);
        int rows = list.get(0).size();
        int cols = list.size();

        String result = "";

        if(rows < cols) {
            for(List<String> strings : list) {
                result += String.join("", strings);
                result += " ";
            }
        } else {
            // rows = 4
            // cols = 3
            for(int i=0; i<cols; i++) {
                for(int j=0; j<rows; j++) {
                    if(j >= list.get(i).size()-1) result += "1";
                    else result += list.get(j).get(i);
                }
                result += " ";
            }
        }

        System.out.println(result);

        return result;
    }

}
