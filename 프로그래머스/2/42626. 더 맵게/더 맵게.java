import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for(int s : scoville) {
            pq.offer(s);
        }
        
        while(pq.size() >= 2 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            
            pq.offer(first + (2*second));
            answer++;
        }
        
        if(pq.peek() < K) return -1;
        return answer;
    }
}