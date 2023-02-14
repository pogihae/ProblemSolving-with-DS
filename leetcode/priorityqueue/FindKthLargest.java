//priority queue comparator

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(nums.length);
        for (int num : nums) {
            pq.add(num * -1);
        }

        for (int i=0; i<k-1; i++) {
            pq.poll();
        }

        return pq.poll() * -1;
    }
}
