import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> mainL = new LinkedList<>();
        Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minQ = new PriorityQueue<>();
        
        for(String str : operations){
            String[] line = str.split(" ");
            char op = line[0].charAt(0);
            Integer data = Integer.valueOf(line[1]);
            
            switch(op){
                case 'I':
                    mainL.add(Integer.valueOf(data));
                    maxQ.add(data);
                    minQ.add(data);
                    break;
                case 'D':
                    if(data == 1) while(!mainL.isEmpty() && !mainL.remove(maxQ.poll()));
                    else while(!mainL.isEmpty() && !mainL.remove(minQ.poll()));
                    break;
            }
        }
        
        int[] answer = new int[2];
            if(!mainL.isEmpty()){
                while(!mainL.contains(maxQ.peek())) maxQ.poll();
                while(!mainL.contains(minQ.peek())) minQ.poll();
                
                answer[0] = maxQ.poll();
                answer[1] = minQ.poll();
            }
            
            return answer;
    }
}