package datastructure.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {

    private List<E> list = new ArrayList<>();
    private int top = 0;

    // stack 에 값을 push 할 때 사용 (제일 위에 쌓음)
    public E push(E element) {
        list.add(top, element);
        top++;
        return element;
    }

    // stack 에 값을 pop 할 때 사용 (제일 위에서 꺼냄)
    public E pop() {
        E element = list.get(top-1);
        list.remove(top-1);
        top--;
        return element;
    }

    public E peek() {
        return list.get(top-1);
    }

}
