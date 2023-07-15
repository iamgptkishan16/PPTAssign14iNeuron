/*
💡 **Question 2**

A number **N** is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.

Example 1:

Input:
LinkedList: 4->5->6
Output:457

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

public class AddOne {

    public static Node addOne(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node lastNonNine = dummy;
        Node current = head;

        // Find the rightmost non-nine digit
        while (current != null) {
            if (current.data != 9) {
                lastNonNine = current;
            }
            current = current.next;
        }

        // Increment the last non-nine digit
        lastNonNine.data++;

        // Set all digits after the last non-nine digit to 0
        current = lastNonNine.next;
        while (current != null) {
            current.data = 0;
            current = current.next;
        }

        // If the first digit is 0, insert a new node with value 1 at the beginning
        if (dummy.data == 0) {
            dummy.data = 1;
            return dummy;
        }

        return dummy.next;
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
        // Create the linked list: 1 -> 2 -> 3
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        System.out.println("Original Linked List:");
        displayList(head);

        // Add 1 to the number
        head = addOne(head);

        System.out.println("Linked List after adding 1:");
        displayList(head);
    }
}
