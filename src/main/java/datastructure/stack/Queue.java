package datastructure.stack;

import java.util.ArrayList;
import java.util.List;

public class Queue<E> {
    private List<E> list = new ArrayList<>();

    public void enqueue(E value) {
        // 리스트에 값을 추가한다.
        list.add(value);
    }

    public E dequeue() {
        // 항상 처음의 값만 가져온다.
        E value = list.get(0);
        // 처음의 값 삭제
        list.remove(0);
        return value;
    }
}
