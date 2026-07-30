import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes) {
            String category = cloth[1];
            
            map.put(category, map.getOrDefault(category, 0)+1);
        }
        
        // System.out.println(map);
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue()+1;
        }
        
        
        return answer-1;
    }
}