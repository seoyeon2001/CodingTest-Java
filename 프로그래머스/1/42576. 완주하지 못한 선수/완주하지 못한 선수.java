import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String parti : participant) {
            map.put(parti, map.getOrDefault(parti, 0)+1);
        }
        
        for(String comp : completion) {
            map.put(comp, map.get(comp)-1);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            // System.out.println(entry.getKey() + " " + entry.getValue());
            if(entry.getValue() == 1) {
                answer = entry.getKey();
                break;
            }
        }
        
        return answer;
    }
}