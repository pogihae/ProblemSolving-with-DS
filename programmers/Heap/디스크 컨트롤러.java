import java.util.Queue;
import java.util.List;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Collections;

class Solution {
    public int solution(int[][] jobs) {
        Queue<int[]> waitQ = new PriorityQueue<>((x,y) -> x[0] - y[0]);
        List<Integer> endL = new LinkedList<>();
        
        for(int[] j : jobs){
            waitQ.add(j);
        }
        
        int time = 0;
        int[] cur = {-1,-1};
        
        while(endL.size() < jobs.length){
            if(cur[1] <= 0){
                
                if(cur[1] == 0)
                    endL.add(time - cur[0]);
                
                if(!waitQ.isEmpty()){
                    int[] t = waitQ.peek();
                    if(t[0] <= time){
                        cur = getProc(waitQ, time);
                    }
                }
            }
            
            time++;
            cur[1]--;
        }
        
        double answer = 0;
        for(int x : endL){
            answer += x;
        }
        
        return (int)(answer / endL.size());
    }
    
    private int[] getProc(Queue<int[]> q, int time){
        Queue<int[]> tmp = new PriorityQueue<>((x,y) -> x[1] - y[1]);
        
        while(!q.isEmpty()){
            int[] x = q.peek();
            if(x[0] <= time){
                tmp.add(q.poll());
            }
            else break;
        }
        
        int[] result = tmp.poll();
        
        for(int[] x : tmp)
            q.add(x);
        
        return result;
    }
}