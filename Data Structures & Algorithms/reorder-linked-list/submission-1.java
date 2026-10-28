/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val;
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*
          j
          i
1 -> 2 -> 3 -> 4 -> 5


1 -> 5 -> 2 -> 4 -> 3
*/
class Solution {
    public void reorderList(ListNode head) {
        var array = new ArrayList<ListNode>();

        var it = head;
        while (it != null) {
            array.add(it);
            it = it.next;
        }

        var i = 0;
        var j = array.size() - 1;

        while (i < j) {
            array.get(i).next = array.get(j);
            i++;
            if (i == j) break;
            array.get(j).next = array.get(i);
            j--;
        }
        array.get(i).next = null;
    }
}