package data_structures_and_algorithms_CS210.Second_Cohort.week21_LinkedList;

public class MergeTwoSortedLists {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //base case
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        //otherwise check if the value in 1st lis is smaller then 2nd lis
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        //otherwise
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }
}
