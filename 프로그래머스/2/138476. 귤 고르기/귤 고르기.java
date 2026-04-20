import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int t : tangerine) {
            if(!map.containsKey(t)) map.put(t, 1);
            else map.put(t, map.get(t)+1);
        }
        // System.out.println(map);
        
        // int[] map = new int[10000001];
        // for(int t : tangerine) {
        //     map[t]++;
        // }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        for(Map.Entry<Integer, Integer> m : map.entrySet()) {
            q.add(new int[] {m.getKey(), m.getValue()});
        }
        
        while(k > 0 && !q.isEmpty()) {
            int[] cur = q.poll();
            k -= cur[1];
            answer++;
        }
        return answer;
    }
}