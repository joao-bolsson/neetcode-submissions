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

class Solution {
    public boolean hasCycle(ListNode head) {
        
        var visited = new HashSet<ListNode>();
        var it = head;
        while (it != null) {
            if (visited.contains(it)) return true;
            visited.add(it);
            it = it.next;
        }
        return false;
    }
}
