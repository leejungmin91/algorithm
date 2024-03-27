package priorityqueue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityQueueTest {
    public static void main(String[] args) {

        PriorityQueue<User> pQ = new PriorityQueue<>(Comparator.comparing(User::getUserNo, Collections.reverseOrder()));

        pQ.offer(new User(3, "1"));
        pQ.offer(new User(1, "2"));
        pQ.offer(new User(2, "3"));

        // stream을 사용함
        pQ.forEach(System.out::println);
        System.out.println("--------------------------");
        // 새로운 Stream을 생성해 poll
        Stream.generate(pQ::poll)
                .limit(pQ.size())
                .forEach(System.out::println);
        System.out.println("--------------------------" + pQ.size());
    }
}
