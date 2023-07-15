/*

💡 **Question 8**

Given the `head` of a linked list, we repeatedly delete consecutive sequences of nodes that sum to `0` until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.

(Note that in the examples below, all sequences are serializations of `ListNode` objects.)

**Example 1:**

Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.

*/

package Java_DSA.LinkedList.Assignment14;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class removeZeroSumSublistsLL {
    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;
        while (current != null) {
            int sum = 0;
            ListNode runner = current.next;

            while (runner != null) {
                sum += runner.val;

                if (sum == 0) {
                    current.next = runner.next;
                    break;
                }

                runner = runner.next;
            }

            if (runner == null) {
                current = current.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);

        ListNode result = removeZeroSumSublists(head);

        // Print the resulting linked list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
