package hackerrank;

import java.util.Arrays;

public class CountingValleys {

    private static int before = 0;
    private static int height = 0;

    public static void main(String[] args) {
        System.out.println(countingValleys(8,"DDUUUUDD"));
    }

    public static int countingValleys(int steps, String path) {
        // DDUUUUDD
        // 0-10123-2-1
        // ->
        String[] stepArr = path.split("");
        int[] heightArr = new int[stepArr.length+1];

        heightArr[0] = 0;

        int valleyCount = 0;

        for(int i=0; i<stepArr.length; i++) {
            if(stepArr[i].equals("U")) heightArr[i+1] = heightArr[i] + 1;
            else if(stepArr[i].equals("D")) heightArr[i+1] = heightArr[i] - 1;
        }

        System.out.println(Arrays.toString(heightArr));

        // 0 -> -1 개수
        for(int i=1; i<heightArr.length; i++) {
            if(heightArr[i-1] == 0 && heightArr[i] == -1) valleyCount++;
        }

        return valleyCount;
    }

}
