package data_structures_and_algorithms_CS210.DS_HEAPS;

public class MergeKSortedLists {
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//        ListNode dummy = new ListNode(-1);
//        ListNode prev = dummy;
//
//        while (true) {
//            ListNode minNode = null;
//            int minIdx = -1;
//
//            // Iterate over lists
//            for (int i = 0; i < lists.length; ++i) {
//                ListNode currList = lists[i];
//                if (currList == null) continue;
//                if (minNode == null || currList.val < minNode.val) {
//                    minNode = currList;
//                    minIdx = i;
//                }
//            }
//            // check if finished
//            if (minNode == null) break;
//
//            // link
//            prev.next = minNode;
//            prev = prev.next;
//
//            // delete
//            lists[minIdx] = minNode.next; // may be null
//        }
//        return dummy.next;
//    }
}
