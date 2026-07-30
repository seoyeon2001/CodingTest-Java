import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        // System.out.println(map);
        // System.out.println(map.keySet());
        // System.out.println(map.keySet().size());
        
        int cnt = map.keySet().size();
        
        if(cnt < answer) answer = cnt;
        
        
        return answer;
    }
}