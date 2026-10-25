import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for(int s : scoville) {
            pq.offer(s);
        }
        
        while(pq.peek() < K) {
            if(pq.size() == 1) {
                if(pq.peek() < K) {
                    answer = -1;
                    break;
                } else {
                    answer++;
                    break;
                }
            }
            int first = pq.poll();
            int second = pq.poll();
            
            int newScoville = first + (second * 2);
            
            // System.out.println(first + ", " + second + "로 " + newScoville);
            pq.offer(newScoville);
            answer++;
        }
        return answer;
    }
}