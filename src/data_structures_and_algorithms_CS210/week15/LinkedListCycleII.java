package data_structures_and_algorithms_CS210.week15;

public class LinkedListCycleII {

    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // They met at the meeting point.
                // Note that we don't know any of a, b, x, y, and L.
                break;
            }
        }
        if (fast == null || fast.next == null) {
            // There was no cycle in the linked list. :)
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
