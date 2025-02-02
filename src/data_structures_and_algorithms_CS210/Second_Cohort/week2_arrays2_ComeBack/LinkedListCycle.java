package data_structures_and_algorithms_CS210.Second_Cohort.week2_arrays2_ComeBack;

public class LinkedListCycle {
    /**
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     * <p>
     * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
     * <p>
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
     * Example 2:
     * <p>
     * <p>
     * Input: head = [1,2], pos = 0
     * Output: true
     * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
     */

//called tortoise and hare bc we have 2 pointers and 1 pointer is faster then another, both stand at head -> slow(1 step at a time) and fast(2 steps at a time)
//make 2 pointers, make them walk, if fast pointer reaches null then we know there is no cycle, if they meet then we should return true, means there is a cycle
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                //they met there is a cycle
                return true;
            }
        }
        // fast pointer reached null or fast.next is null, which means end of the
        // linked list. So, there is no cycle in the linked list – return false.
        return false;
    }

}
