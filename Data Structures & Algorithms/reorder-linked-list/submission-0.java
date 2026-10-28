/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode()
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
               n
                    i 
0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6

                              h
0 -> 6 -> 1 -> 5 -> 2 -> 4 -> 3


*/

class Solution {
    public void reorderList(ListNode head) {
        var array = new ArrayList<ListNode>();

        var it = head;
        while (it != null) {
            array.add(it);
            it = it.next;
        }

        var i = 1;
        var n = array.size() - 1;

        it = head;
        while (i < n) {
            it.next = array.get(n);
            
            it = it.next;
            it.next = array.get(i);
            it = it.next;

            i++;
            n--;
        }
        if (i == n) {
            it.next = array.get(n);
            it = it.next;
        }
        it.next = null;
    }
}