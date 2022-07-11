import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>(numbers.length);
    
        for(int i=0; i<numbers.length; i++){
            list.add(String.valueOf(numbers[i]));
        }
        
        Collections.sort(list,(x,y) -> (y+x).compareTo(x+y));
        
        String answer = String.join("", list);
        
        return (answer.charAt(0) == '0')? "0" : answer; 
    }
}