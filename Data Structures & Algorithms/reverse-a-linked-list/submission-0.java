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

                       n
                   p
                       h
    0 <- 1 <- 2 <- 3

*/
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;

        while (head != null) {
            var next = head.next;

            head.next = previous;
            previous = head;

            head = next;
        }
        return previous;
    }
}
