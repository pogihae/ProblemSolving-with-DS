import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] operations) {

        Queue<Integer> minQ = new PriorityQueue<>();
        Queue<Integer> tempQ = new PriorityQueue<>();

        String[] first = operations[0].split(" ");
        int max = Integer.parseInt(first[1]);
        int tmpMax = max;

        for(String op : operations){
            String[] s = op.split(" ");
            int data = Integer.parseInt(s[1]);

            if(s[0].equals("I")){
                minQ.add(data);
                if(data > max) max = data;
            }
            else{
                if(data == 1){
                    while(!minQ.isEmpty() && minQ.peek() < max){
                        tmpMax = minQ.poll();
                        tempQ.add(tmpMax);
                    }
                    max = tmpMax;    
                    minQ.poll();
                    while(!tempQ.isEmpty())
                        minQ.add(tempQ.poll());
                }
                else{
                    minQ.poll();
                }
            }
        }

        int[] answer = new int[2];
        if(minQ.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            answer[0] = max;
            answer[1] = minQ.poll();
        }
        return answer;
    }
}