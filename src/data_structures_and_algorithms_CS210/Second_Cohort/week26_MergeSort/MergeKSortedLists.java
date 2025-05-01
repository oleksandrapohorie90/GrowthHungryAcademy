package data_structures_and_algorithms_CS210.Second_Cohort.week26_MergeSort;

public class MergeKSortedLists {
    /**
     * Definition for singly-linked list.
     **/
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


        class Solution {
            public ListNode mergeKLists(ListNode[] lists) {
                return mergeAllLists(lists, 0, lists.length - 1);
            }

            private ListNode mergeAllLists(ListNode[] lists, int left, int right) {
                if (left > right) return null;
                if (left == right) return lists[left];

                int middle = (left + right) / 2;

                ListNode merged_left_half_lists = mergeAllLists(lists, left, middle);
                ListNode merged_right_half_lists = mergeAllLists(lists, middle + 1, right);

                return mergeTwoSortedLists(merged_left_half_lists,
                        merged_right_half_lists);
            }

            private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
                if (l1 == null) return l2;
                if (l2 == null) return l1;

                if (l1.val < l2.val) {
                    l1.next = mergeTwoSortedLists(l1.next, l2);
                    return l1;
                } else {
                    l2.next = mergeTwoSortedLists(l1, l2.next);
                    return l2;
                }

                // l1 -> merge(l1.next, l2)
                // l2 -> merge(l2.next, l1)
            }
        }
    }
}
