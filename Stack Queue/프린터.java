import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;


class Solution {
    public int solution(int[] priorities, int location) {

        Queue<Docs> q = new LinkedList<>();
        Queue<Integer> maxs = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<priorities.length; i++){
            q.add(new Docs(priorities[i], i));
            maxs.add(priorities[i]);
        }

        int answer = 1;

        while(!q.isEmpty()){

            //compare first with max
            while(!q.isEmpty()){
                if(q.peek().priority >= maxs.peek())
                    break;
            //if first < max, move to last
                q.add(q.poll());
                }

            //print -> save in array
            if(q.poll().location == location) break;
            
            answer++;
            maxs.poll();
        }
        
        return answer;
    }

        //docs class
        private class Docs{
            int priority;
            int location;

            Docs(int priority, int location){
                this.priority = priority;
                this.location = location;
            }
        }
}