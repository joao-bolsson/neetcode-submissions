/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
     i
[1,2,4]

     j
[1,3,5]

   k
[3,6]
*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode curr = null, head = null;
        while (true) {
            var min = Integer.MAX_VALUE;
            var idx = -1;
            for (var i = 0; i < lists.length; i++) {
                var node = lists[i];
                if (node != null && node.val <= min) {
                    min = node.val;
                    idx = i; // choose one list to go move next
                }
            }

            if (idx == -1) break;

            lists[idx] = lists[idx].next;

            var node = new ListNode(min);
            if (curr == null) {
                curr = node;
            } else {
                curr.next = node;
                curr = node;
            }

            if (head == null) head = curr;
        }

        return head;
    }
}
