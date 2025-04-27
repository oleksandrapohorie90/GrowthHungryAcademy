package data_structures_and_algorithms_CS210.Second_Cohort.week21_LinkedList;

public class ReverseLinkedList {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        /* recursive solution */
        return reverseListRecursive(head, null);
    }

    private ListNode reverseListRecursive(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        // BEFORE THE FIRST CALL, THE LINKED LIST LOOKS LIKE BELOW
        // head -> head.next -> head.next.next -> head.next.next.next -> ... -> head.[many] -> null

        // FIRST CALL
        // reverseListRecursive(head, null)
        // null    head -> head.next -> head.next.next -> head.next.next.next -> ... -> head.[many] -> null

        ListNode next = head.next;
        head.next = newHead;

        // null <- head    head.next -> head.next.next -> head.next.next.next -> ... -> head.[many] -> null

        // SECOND CALL
        // reverseListRecursive(head.next, head)
        // null <- head    head.next -> head.next.next -> head.next.next.next -> ... -> head.[many] -> null
        // null <- head <- head.next    head.next.next -> head.next.next.next -> ... -> head.[many] -> null

        // THIRD CALL
        // reverseListRecursive(head.next.next, head.next)
        // null <- head <- head.next    head.next.next -> head.next.next.next -> ... -> head.[many] -> null
        // null <- head <- head.next <- head.next.next    head.next.next.next -> ... -> head.[many] -> null

        // AND SO ON.. UNTIL LAST CALL reverseListRecursive(null, head.[many]) IS CALLED
        // null <- head <- head.next <- head.next.next <- head.next.next.next <- ... <- head.[many]    null
        // WE THEN RETURN head.[many] AND IT IS GOING TO BE RETURNED BACK TO LINE 14, BECAUSE IT IS THE NEW HEAD.
        return reverseListRecursive(next, head);
    }
}

