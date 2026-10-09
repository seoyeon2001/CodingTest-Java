import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Deque<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for(int i = 0; i < priorities.length; i++) {
            q.add(new int[] {priorities[i], i});
            pq.add(priorities[i]);
        }
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(cur[0] < pq.peek()) {
                q.add(cur);
            } else {
                answer++;
                pq.poll();
                if(cur[1] == location) return answer;
            }
        }
        return answer;
    }
}