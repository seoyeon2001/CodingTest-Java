import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < prices.length; i++) {
            int price = prices[i];
            
            while(!q.isEmpty() && q.peek()[0] > price) {
                int[] top = q.poll();
                answer[top[1]] = i - top[1];
            }
            
            q.push(new int[] {prices[i], i});
        }
        
        while(!q.isEmpty()) {
            int idx = q.poll()[1];
            answer[idx] = prices.length - 1 - idx;
        }
        return answer;
    }
}