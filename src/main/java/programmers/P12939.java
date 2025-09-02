package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P12939 {
    public String solution(String s) {
        String answer = "";
        List<Integer> numbers = Arrays.stream(s.split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        answer = numbers.stream().min(Integer::compareTo).orElse(0) + " " + numbers.stream().max(Integer::compareTo).orElse(0);
        return answer;
    }
}
