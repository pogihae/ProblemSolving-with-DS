import java.util.Collections;
import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Integer[] tmp = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        
        Arrays.sort(tmp, Collections.reverseOrder());
        
        for(answer = 0; answer<tmp.length; answer++){
            if(answer >= tmp[answer]){
                break;
            }
        }
        
        return answer;
    }
}