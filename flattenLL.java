/*
💡 **Question 3**

Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:(i) a **next** pointer to the next node,(ii) a **bottom** pointer to a linked list where this node is head.Each of the sub-linked-list is in sorted order.Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. **Note:** The flattened list will be printed using the bottom pointer instead of next pointer.

**Example 1:**

Input:
5 -> 10 -> 19 -> 28
|     |     |     |
7     20    22   35
|           |     |
8          50    40
|                 |
30               45
Output: 5-> 7-> 8- > 10 -> 19-> 20->
22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation:
The resultant linked lists has every
node in a single level.(Note:| represents the bottom pointer.)


*/ 


package Java_DSA.LinkedList.Assignment14;


class Node {
    int data;
    Node next;
    Node bottom;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }
}

public class flattenLL {

    public static Node flattenLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Merge two sorted lists
        head.next = flattenLinkedList(head.next);

        head = mergeLists(head, head.next);

        return head;
    }

    public static Node mergeLists(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        Node result;

        if (a.data < b.data) {
            result = a;
            result.bottom = mergeLists(a.bottom, b);
        } else {
            result = b;
            result.bottom = mergeLists(a, b.bottom);
        }

        result.next = null;
        return result;
    }

    public static void displayList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the linked list of sub-linked lists
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(19);
        head.next.next.next = new Node(28);

        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next.bottom = new Node(20);

        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        System.out.println("Original Linked List:");
        displayList(head);

        // Flatten the linked list
        head = flattenLinkedList(head);

        System.out.println("Flattened Linked List:");
        displayList(head);
    }
}
