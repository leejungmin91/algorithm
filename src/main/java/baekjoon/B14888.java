package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B14888 {

    private static int[] numbers;
    private static final Map<String, Integer> operators = new HashMap<>();

    private static long max = Integer.MIN_VALUE;
    private static long min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        numbers = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int plusCount = Integer.parseInt(st.nextToken());
        int minusCount = Integer.parseInt(st.nextToken());
        int multiplyCount = Integer.parseInt(st.nextToken());
        int divideCount = Integer.parseInt(st.nextToken());

        operators.put("+", plusCount);
        operators.put("-", minusCount);
        operators.put("*", multiplyCount);
        operators.put("/", divideCount);

        // 5 6
        // 0 0 1 0
        // 5 * 6

        dfs(numbers[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int num, int index) {
        if(index >= numbers.length) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(Map.Entry<String, Integer> entry : operators.entrySet()) {
            String operator = entry.getKey();
            int count = entry.getValue();
            if(count > 0) {
                operators.put(operator, operators.get(operator) - 1);
                switch (operator) {
                    case "+" -> dfs(num + numbers[index], index + 1);
                    case "-" -> dfs(num - numbers[index], index + 1);
                    case "*" -> dfs(num * numbers[index], index + 1);
                    case "/" -> dfs(num / numbers[index], index + 1);
                }
                operators.put(operator, operators.get(operator) + 1);
            }
        }
    }

}
