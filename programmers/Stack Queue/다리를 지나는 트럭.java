import java.util.Queue;
import java.util.LinkedList;

class Solution {
    int curWeight = 0;
    int curLength = 0;
    int time = 1;
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitQ = new LinkedList<>();
        Queue<Truck> runQ = new LinkedList<>();
        Queue<Integer> weights = new LinkedList<>();
        
        for(int w : truck_weights) waitQ.add(w);
        
        while(!waitQ.isEmpty() || !runQ.isEmpty()){
            if(canLoad(waitQ, weight, bridge_length)){
                int tmpW = waitQ.poll();
                
                curWeight += tmpW;
                curLength++;
                
                runQ.add(new Truck(bridge_length));
                weights.add(tmpW);
            }
            
            time++;
            runQ.forEach(Truck::minus);
            
            if(runQ.peek().length <= 0){
                runQ.poll();
                curLength--;
                curWeight -= weights.poll();
            }
        }
        
        return time;
    }
    
    private boolean canLoad(Queue<Integer> waitQ, int weight, int length){
        if(waitQ.isEmpty()) return false;
        
        return ((waitQ.peek() + curWeight) <= weight) &&
            ((curLength+1) <= length);
    }
    
    public class Truck{
        int length;
        Truck(int length){
            this.length = length;
        }
        void minus(){
            this.length -= 1;
        }
    }
}