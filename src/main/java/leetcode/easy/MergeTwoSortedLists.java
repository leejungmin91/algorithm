package leetcode.easy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MergeTwoSortedLists {

    public static void main(String[] args) throws IOException {
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();
        System.out.println(solution(list1, list2).val);
    }

    public static ListNode solution(ListNode list1, ListNode list2) {
        /**
         * 1,2,4    1,3,4 -> 1,1,2,3,4
         * 1,2,3    5,6,7 -> 1,2,3,5,6,7
         */

        List<Integer> mergeList = new ArrayList<>();

        if(list1 == null && list2 == null) return null;

        ListNode node1 = list1;

        while(node1 != null) {
            mergeList.add(node1.val);
            node1 = node1.next;
        }

        ListNode node2 = list2;

        while(node2 != null) {
            mergeList.add(node2.val);
            node2 = node2.next;
        }

        Collections.sort(mergeList);

        List<ListNode> nodeList = mergeList.stream()
                .map(ListNode::new)
                .collect(Collectors.toList());

        if(nodeList.size() == 1) return nodeList.get(0);

        ListNode resultNode = new ListNode(nodeList.get(nodeList.size()-1).val);

        for(int i=nodeList.size()-2; i>=0; i--) {
            resultNode = new ListNode(nodeList.get(i).val, resultNode);
        }

        return resultNode;
    }

    public static ListNode getNextNode(ListNode node) {
        return node.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
