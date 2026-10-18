import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);
        
        int[] arr = {781, 156, 31, 6, 1};
        
        char[] c = word.toCharArray();
        for(int i = 0; i < word.length(); i++) {
            answer += map.get(c[i]) * arr[i];
            answer++;
        }
                              
        return answer;
    }
}