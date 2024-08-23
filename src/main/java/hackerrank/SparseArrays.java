package hackerrank;

import java.util.List;
import java.util.stream.Collectors;

public class SparseArrays {

    public static void main(String[] args) {
        List<String> stringList = List.of("aba", "baba", "aba", "xzxb");
        List<String> queries = List.of("aba", "xzxb", "ab");

        System.out.println(matchingStrings(stringList, queries));
    }

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        //return stringList.stream().map(str -> (int) queries.stream().filter(q -> q.equals(str)).count()).collect(Collectors.toList());
        return queries.stream()
                .map(q -> (int) stringList.stream()
                        .filter(s -> s.equals(q))
                        .count()
                )
                .collect(Collectors.toList());
    }

}
