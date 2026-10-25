import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long s : scoville) {
            pq.offer(s);
        }
        
        while(pq.peek() < K) {
            if(pq.size() == 1) {
                answer = -1;
                break;
            }
            
            long first = pq.poll();
            long second = pq.poll();
            
            long newScoville = first + (second * 2);
            
            pq.offer(newScoville);
            answer++;
        }
        
        return answer;
    }
}