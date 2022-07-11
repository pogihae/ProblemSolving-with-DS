import java.util.Queue;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> q = new PriorityQueue<>();
        
        for(int s : scoville){
            q.add(s);
        }
        
        while(q.peek() < K){
            if(q.size() <= 1) return -1;
            
            int first = q.poll();
            int second = q.poll();
            
            int mixed = first + (second * 2);
            
            q.add(mixed);
            answer++;
        }
        
        return answer;
    }
}