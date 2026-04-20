import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for(String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        
        // System.out.println(map);
        
        for(String com : completion) {
            map.put(com, map.get(com) - 1);
            // System.out.println(map);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }
        
        return answer;
    }
}