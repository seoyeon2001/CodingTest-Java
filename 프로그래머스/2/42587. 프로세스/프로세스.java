import java.util.*;

class Solution {
    static class Pro {
        int priority;
        int idx;
        
        Pro(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Pro> pq = new PriorityQueue<>((a, b) -> b.priority - a.priority);
        Deque<Pro> q = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++) {
            pq.add(new Pro(priorities[i], i));
            q.add(new Pro(priorities[i], i));
        }
        
        int order = 0;
        while(!q.isEmpty()) {
            Pro cur = q.poll();
            
            if(cur.priority < pq.peek().priority) {
                q.add(cur);
            } else if(cur.priority == pq.peek().priority) {
                order++;
                pq.poll();
                
                if(cur.idx == location) {
                    answer = order;
                    break;
                }
            }
        }
        return answer;
    }
}