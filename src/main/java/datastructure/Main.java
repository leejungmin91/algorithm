package datastructure;

import datastructure.stack.Queue;
import datastructure.stack.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // 예상 결과값은 4
        System.out.println("stack 4 == "+stack.peek());
        stack.pop();
        stack.pop();
        // 예상 결과값은 2
        System.out.println("stack 2 == "+stack.peek());

        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("queue 1 == "+queue.dequeue());
        queue.enqueue(4);
        System.out.println("queue 2 == "+queue.dequeue());

    }
}
