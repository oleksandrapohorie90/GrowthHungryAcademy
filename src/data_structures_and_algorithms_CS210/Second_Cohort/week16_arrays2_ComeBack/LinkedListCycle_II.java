package data_structures_and_algorithms_CS210.Second_Cohort.week16_arrays2_ComeBack;

public class LinkedListCycle_II {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * find the entry point of the cycle
     * we have 2 pointers that met at some point, but we have no idea where is the beginning of the cycle, we need Math
     * A - num of steps to get to entry point to cycle
     * B - num of steps from the entry point to the meeting point in the cycle
     */
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
            // There was no cycle in the linked list.
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
