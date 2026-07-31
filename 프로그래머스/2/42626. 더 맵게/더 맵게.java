import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        
        for(int s : scoville) {
            pq.add(s);
        }
        // System.out.println(pq);
        
        while(pq.peek() < K) {
            answer++;
            int first = pq.poll();
            int second = pq.poll();
            
            int newS = first + (second*2);
            pq.add(newS);
            // System.out.println(pq);
            
            if(pq.size() == 1 && pq.peek() < K) return -1;
        }
        return answer;
    }
}