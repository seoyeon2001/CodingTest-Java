import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Deque<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < priorities.length; i++) {
            q.addLast(new int[] {i, priorities[i]});
            pq.add(priorities[i]);
        }
        
        // System.out.println(pq);
        
        int high = pq.poll();
        
        while(!q.isEmpty()) {
            int[] now = q.pollFirst();
            // System.out.println(Arrays.toString(now));
            
            if(now[1] < high) {
                q.addLast(now);
            } else if(now[1] == high) {
                answer++;                
                if(now[0] == location) {
                    return answer;
                }
                high = pq.poll();
            }
        
        }
        return answer;
    }
}