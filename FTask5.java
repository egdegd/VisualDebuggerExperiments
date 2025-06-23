/*
You are given an implementation of insertion into a sorted doubly linked list.

The list should maintain ascending order after each insertion.

For example, if we sequentially insert the values 2, 10, 3, and 4 into a list that initially contains a single node with value 1, the final list should be:
    1 → 2 → 3 → 4 → 10

However, the current implementation is incorrect. For the same sequence of insertions, the program outputs:
    1 → 2 → 4 → 10

Your Task
    •	Find and fix the bug in the provided code.
    •	Make as few modifications as possible to achieve correct behavior.
    •	Keep the overall structure and logic of the original code.
 */

class Node {
    int value;
    Node next;
    Node prev;

    Node(int value) {
        this.value = value;
    }
}

public class FTask5 {

    public static Node add(Node head, int x) {
        Node newNode = new Node(x);
        Node current = head;

        while (current.value < x && current.next != null) {
            current = current.next;
        }

        if (current.next == null && current.value < x) {
            // Insert at the end
            newNode.prev = current;
            current.next = newNode;
        } else {
            // Insert before current
            newNode.next = current;
            newNode.prev = current.prev;

            if (current.prev != null) {
                current.prev.next = newNode;
            }
        }
        current.prev= newNode;
        if (head.value < newNode.value) {
            return head;
        } else {
            return newNode;
        }

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head = add(head, 2);
        head = add(head, 10);
        head = add(head, 3);
        head = add(head, 4);

        Node current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}