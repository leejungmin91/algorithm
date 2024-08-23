package hackerrank;

import java.util.*;

public class DetectWhetherALinkedListContainsACycle {
    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 1 -> NULL TRUE
        // 1 -> 2 -> 3 -> NULL FALSE
        SinglyLinkedListNode node = new SinglyLinkedListNode();
        node.data = 1;
        node.next = new SinglyLinkedListNode();
        node.next.data = 1;
        node.next.next = new SinglyLinkedListNode();
        node.next.next.data = 3;
        node.next.next.next = new SinglyLinkedListNode();
        node.next.next.next.data = 1;
        node.next.next.next.next = new SinglyLinkedListNode();
        node.next.next.next.next.data = 2;
        node.next.next.next.next.next = new SinglyLinkedListNode();
        node.next.next.next.next.next.data = 3;

        System.out.println("hasCycle ==> "+hasCycle(node));
    }

    private static boolean hasCycle(SinglyLinkedListNode head) {
        List<Integer> dataList = new ArrayList<>();
        while (head != null) {
            dataList.add(head.data);
            head = head.next;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(Integer data : dataList) {
            map.put(data, map.getOrDefault(data, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return true;
            }
        }

        return false;
    }
}

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
}
