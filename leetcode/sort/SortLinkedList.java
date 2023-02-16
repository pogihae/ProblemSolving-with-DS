class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return head;

        ListNode lo = head;
        ListNode hi = head;

        while (hi.next != null) {
            hi = hi.next;
        }

        mergeSort(lo, hi);
        return head;
    }

    void mergeSort(ListNode lo, ListNode hi) {
        if (lo == hi) return;

        ListNode mid = getMidNode(lo, hi);
        mergeSort(lo, mid);
        mergeSort(mid.next, hi);

        merge(lo, mid, hi);
    }

    ListNode getMidNode(ListNode lo, ListNode hi) {
        ListNode slow = lo;
        ListNode fast = lo;

        while (fast != hi) {
            int goneStep = 0;

            for (; goneStep<2 && fast != hi; goneStep++) {
                fast = fast.next;
            }

            if (goneStep != 2) {
                break;
            }

            slow = slow.next;
        }

        //mid -> left side
        return slow;
    }

    void merge(ListNode lo, ListNode mid, ListNode hi) {
        Queue<Integer> values = new LinkedList<>();

        ListNode left = lo;
        ListNode right = mid.next;

        while (left != mid.next && right != hi.next) {
            if (left.val > right.val) {
                values.add(right.val);
                right = right.next;
            } else {
                values.add(left.val);
                left = left.next;
            }
        }

        while (left != mid.next) {
            values.add(left.val);
            left = left.next;
        }

        while (right != hi.next) {
            values.add(right.val);
            right = right.next;
        }

        while (lo != hi.next) {
            lo.val = values.poll();
            lo = lo.next;
        }
    }
}
