import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<Character, List<String>> map = new HashMap<>();
        
        for(String ph : phone_book){
            Character first = ph.charAt(0);
            if(!map.containsKey(first)) map.put(first, new ArrayList<>());
            map.get(first).add(ph);
        }
        
        for(Entry<Character, List<String>> entry : map.entrySet()){
            List<String> tmp = entry.getValue();
            Collections.sort(tmp);
            int len = tmp.size();
            
            for(int i=0; i<len-1; i++){
                if(tmp.get(i+1).startsWith(tmp.get(i))) return false;
            }
        }
        
        return true;
    }
}