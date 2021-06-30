import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        //need days
        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            que.add((int)Math.ceil((100-progresses[i]) / (double)speeds[i]));
        }
        
        //get progress num per day
        List<Integer> list = new LinkedList<>();
        
        while(!que.isEmpty()){
            int procNum = 1;
            int prev = que.poll();
            while(!que.isEmpty() && prev >= que.peek()){
                que.poll();
                procNum++;
            }
            list.add(procNum);
        }
        
        //return
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}