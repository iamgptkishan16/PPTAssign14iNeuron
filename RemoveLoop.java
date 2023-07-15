/*
💡 **Question 1**

Given a linked list of **N** nodes such that it may contain a loop.

A loop here means that the last node of the link list is connected to the node at position X(1-based index). If the link list does not have any loop, X=0.

Remove the loop from the linked list, if it is present, i.e. unlink the last node which is forming the loop.

**Example 1:**
Input:
N = 3
value[] = {1,3,4}
X = 2
Output:1
Explanation:The link list looks like
1 -> 3 -> 4
     ^    |
     |____|
A loop is present. If you remove it
successfully, the answer will be 1.

*/

package Java_DSA.LinkedList.Assignment14;

class Node {
    int data;
    Node next;
  
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveLoop {

    public static void detectAndRemoveLoop(Node head) {
        if (head == null || head.next == null) {
            return; // Empty list or only one node, no loop
        }

        Node slow = head;
        Node fast = head;

        // Detect the loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break; // Loop found
            }
        }

        // If no loop, return
        if (fast == null || fast.next == null) {
            return;
        }

        // Find the starting point of the loop
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the loop
        fast.next = null;
    }

    public static void displayList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create a loop (5 points back to 2)
        head.next.next.next.next.next = head.next;

        System.out.println("Original Linked List:");
        displayList(head);

        // Remove the loop
        detectAndRemoveLoop(head);

        System.out.println("Linked List after removing the loop:");
        displayList(head);
    }
}
