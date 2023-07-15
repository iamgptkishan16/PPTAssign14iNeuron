/*
💡 **Question 4**

You are given a special linked list with **N** nodes where each node has a next pointer pointing to its next node. You are also given **M** random pointers, where you will be given **M** number of pairs denoting two nodes **a** and **b**  **i.e. a->arb = b** (arb is pointer to random node)**.**

Construct a copy of the given list. The copy should consist of exactly **N** new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes **X** and **Y** in the original list, where **X.arb** **-->** **Y**, then for the corresponding two nodes **x** and **y** in the copied list, **x.arb --> y.**

Return the head of the copied linked list.
**Note** :- The diagram isn't part of any example, it just depicts an example of how the linked list may look like.

**Example 1:**
Input:
N = 4, M = 2
value = {1,2,3,4}
pairs = {{1,2},{2,4}}
Output:1
Explanation:In this test case, there
are 4 nodes in linked list.  Among these
4 nodes,  2 nodes have arbitrary pointer
set, rest two nodes have arbitrary pointer
as NULL. Second line tells us the value
of four nodes. The third line gives the
information about arbitrary pointers.
The first node arbitrary pointer is set to
node 2.  The second node arbitrary pointer
is set to node 4.

*/

package Java_DSA.LinkedList.Assignment14;

class Node {
    int data;
    Node next;
    Node random;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

public class copyRandomLL {
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Create a copy of each node and insert it after the original node
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.data);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Assign random pointers to the copied nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Separate the original and copied lists
        current = head;
        Node copyHead = current.next;
        Node copyCurrent = copyHead;
        while (current != null) {
            current.next = current.next.next;
            if (copyCurrent.next != null) {
                copyCurrent.next = copyCurrent.next.next;
            }
            current = current.next;
            copyCurrent = copyCurrent.next;
        }

        return copyHead;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            int randomData = (current.random != null) ? current.random.data : -1;
            System.out.println("Node: " + current.data + ", Random: " + randomData);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        // Create the original linked list with random pointers
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Assign random pointers
        head.random = head.next.next;
        head.next.random = head.next.next.next;
        head.next.next.random = head;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;

        // Copy the linked list
        Node copyHead = copyRandomList(head);

        // Print the original and copied lists
        System.out.println("Original Linked List:");
        printList(head);

        System.out.println("Copied Linked List:");
        printList(copyHead);
    }
}
