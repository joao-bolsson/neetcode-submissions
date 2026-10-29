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

n = 4
1 -> 2 -> 3 -> 4  =>  2 -> 3 -> 4 

n = 3
1 -> 2 -> 3 -> 4  =>  1 -> 3 -> 4 

*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var size = 0;

        var it = head;
        while (it != null) {
            size++;
            it = it.next;
        }

        // remove the first node
        if (n == size) return head.next;

        ListNode prev = null;
        var curr = head;
        var i = size;
        while (i > n) {
            prev = curr;
            curr = curr.next;
            i--;
        }
        prev.next = curr.next;
        return head;
    }
}
