package programmers;

public class P70129 {

    int zeroCount = 0;

    public int[] solution(String s) {
        // "110010101001" -> [3,8]
        // 110010101001 -> 6 -> 110 -> 2 -> 10 -> 1 3번 이진변환하였고 제거된 0은 8개
        int convertedCount = 0;

        while(!s.equals("1")) {
            // 이진변환
            int len = binaryConvertedLength(s);
            // 0 제거 후 길이 -> 이진수 변환
            s = binary(len);
            convertedCount++;
        }

        return new int[]{convertedCount, zeroCount};
    }

    public int binaryConvertedLength(String s) {
        String[] splitS = s.split("");
        for(String str : splitS){
            if(str.equals("0")) zeroCount++;
        }
        return s.replaceAll("0", "").length();
    }

    public String binary(int s) {
        return Integer.toBinaryString(s);
    }

}
