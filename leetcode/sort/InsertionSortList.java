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
    public ListNode insertionSortList(ListNode head) {
        ListNode root = new ListNode(Integer.MIN_VALUE);
        ListNode prev = root;

        while (head != null) {
            ListNode tmp = head.next;

            if (prev.val < head.val) {
                insert(prev, head);
            } else {
                insert(root, head);
            }

            prev = head;
            head = tmp;
        }

        return root.next;
    }

    void insert(ListNode root, ListNode node) {
        ListNode prev = root;
        ListNode cur = root.next;

        while (cur != null && cur.val < node.val) {
            prev = cur;
            cur = cur.next;
        }
        node.next = cur;
        prev.next = node;
    }
}
