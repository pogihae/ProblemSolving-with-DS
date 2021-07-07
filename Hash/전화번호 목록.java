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
            Collections.sort(tmp, (x,y) -> x.length() - y.length());
            int start = 0;
            int len = tmp.size();
            
            for(String ph : tmp){
                for(int i = start; i<len; i++){
                    if(ph.length() == tmp.get(i).length()) continue;
                    if(ph.equals(tmp.get(i).substring(0,ph.length())))
                        return false;
                }
                start++;
            }
        }
        
        return true;
    }
}