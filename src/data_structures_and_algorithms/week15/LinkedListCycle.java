package data_structures_and_algorithms.week15;

public class LinkedListCycle {
    //Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // They met! There is a cycle.
                return true;
            }
        }
        // fast pointer reached null or fast.next is null, which means end of the
        // linked list. So, there is no cycle in the linked list – return false. :)
        return false;
    }

    public static void main(String[] args) {
        ListNode ln = new ListNode(10);
        hasCycle(ln);
    }
}
