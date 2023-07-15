/*
💡 **Question 7**

You are given the `head` of a linked list with `n` nodes.

For each node in the list, find the value of the **next greater node**. That is, for each node, find the value of the first node that is next to it and has a **strictly larger** value than it.

Return an integer array `answer` where `answer[i]` is the value of the next greater node of the `ith` node (**1-indexed**). If the `ith` node does not have a next greater node, set `answer[i] = 0`.

**Example 1:**
Input: head = [2,1,5]
Output: [5,5,0]


*/
package Java_DSA.LinkedList.Assignment14;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class nextGreaterNodesLL {
    public static int[] nextGreaterNodes(ListNode head) {
        // Convert the linked list to an array
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        int n = list.size();
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                answer[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(7);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(9);

        int[] result = nextGreaterNodes(head);

        System.out.println(Arrays.toString(result));
    }
}
