package data_structures_and_algorithms_CS210.Second_Cohort.week21;

public class ReverseLinkedList_II {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // (1) -> (2) -> (10) -> (20) -> (30) -> (40) -> (5)

        ListNode dummy = new ListNode(0); // created dummy node
        dummy.next = head;

        //                 reversing [<-------<---------->------->]
        // dummy (0) -> (1) -> (2) -> (10) -> (20) -> (30) -> (40) -> (5)

        ListNode prev = dummy; // intialising prev pointer on dummy node

        for (int i = 0; i < left - 1; i++) { // -> move pre to (2)
            prev = prev.next; // adjusting the prev pointer on it's actual index
        }

        //                     reversing [<-------<---------->------->]
        // dummy (0) -> (1) -> pre (2) -> (10) -> (20) -> (30) -> (40) -> (5)

        // curr pointer will be just after prev
        ListNode curr = prev.next; // -> cur is (10)

        //                          reversing [<-------<---------->------->]
        // dummy (0) -> (1) -> pre (2) -> curr (10) -> (20) -> (30) -> (40) -> (5)

        // reversing
        for (int i = 0; i < right - left; i++) {
            // forw pointer will be after curr
            ListNode forw = curr.next;
            curr.next = forw.next; // Step A
            forw.next = prev.next; // Step B
            prev.next = forw; // Step C

            // left = 3, right = 6 -> so, the loop will execute 3 times
            // -------------–-------------–-------------–-------------–-------------–-------------–-------
            // 1st execution
            //                                        reversing [<-------<---------->------->]
            // Initially:    dummy (0) -> (1) -> pre (2) -> curr (10) -> forw (20) -> (30) -> (40) -> (5)
            //
            // After Step A: dummy (0) -> (1) -> pre (2) -> curr (10)    forw (20) -> (30) -> (40) -> (5)
            //                                                      v                 ^
            //                                                      |_________________|
            //
            // After Step B: dummy (0) -> (1) -> pre (2) -> curr (10)    forw (20)    (30) -> (40) -> (5)
            //                                                   ^  v            v    ^
            //                                                   |  |____________|____|
            //                                                   |               |
            //                                                   |_______________|
            //
            // After Step C: dummy (0) -> (1) -> pre (2)    curr (10)    forw (20)    (30) -> (40) -> (5)
            //                                         v         ^  v         ^  v    ^
            //                                         |         |  |_________|__|____|
            //                                         |         |               |
            //                                         |         |____________|__|
            //                                         |______________________|
            // After Step C: dummy (0) -> (1) -> pre (2)    curr (10)    forw (20)    (30) -> (40) -> (5)
            //                                         v         ^  v         ^  v    ^
            //                                         |         |  |_________|__|____|
            //                                         |         |               |
            //                                         |         |____________|__|
            //                                         |______________________|
            //
            // Untangle:     dummy (0) -> (1) -> pre (2) -> forw (20) -> curr (10) -> (30) -> (40) -> (5)
            //
            // I will not draw next executions :D That's enough to understand this solution.
        }
        return dummy.next;
    }

}
