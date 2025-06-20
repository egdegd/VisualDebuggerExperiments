/*
Problem Statement

Given the head of a singly linked list, rotate the list to the right by `k` places.

You are provided with a Java implementation that attempts to solve this task using a cycle-based approach.

However, there is a bug in the implementation that causes incorrect output for certain values of `k`.

For example, for the input list:
    1 → 2 → 3 → 4 → 5
and k = 2,
the expected output is:
    4 → 5 → 1 → 2 → 3

But the current program outputs:
    5 → 1 → 2 → 3 → 4

Your Task
    •	Find and fix the bug in the provided code.
    •	Make as few modifications as possible to achieve correct behavior.
    •	Keep the overall structure and logic of the original code.

 */


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k < 1 || head == null || head.next == null) {
            return head;
        }

        ListNode last = head;
        int length = 1;

        while (last.next != null) {
            length++;
            last = last.next;
        }

        last.next = head;

        int rotations = k+1 % length;
        ListNode newLast = head;
        for (int i = 0; i < length - rotations; i++) {
            newLast = newLast.next;
        }

        ListNode newHead = newLast.next;
        newLast.next = null;

        return newHead;
    }
}

public class FTask6 {
    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        Solution solution = new Solution();
        ListNode rotatedList = solution.rotateRight(node1, 2);

        // Print rotated list
        ListNode cur = rotatedList;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}