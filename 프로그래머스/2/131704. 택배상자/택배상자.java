import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= order.length; i++) {
            q.addLast(i);
        }
        Deque<Integer> subQ = new ArrayDeque<>();
        
        int turn = order[0];
        while(!subQ.isEmpty() || !q.isEmpty()) {
            if(!q.isEmpty() && turn == q.peekFirst()) {
                q.pollFirst();
                answer++;
                if(answer == order.length) break;
                turn = order[answer];
            } else if(!subQ.isEmpty() && turn == subQ.peekFirst()) {
                subQ.pollFirst();
                answer++;
                if(answer == order.length) break;
                turn = order[answer];
            } else {
                if(!q.isEmpty()) {
                    subQ.addFirst(q.pollFirst());
                } else {
                    break;
                }
                
            }
        }
        
        return answer;
    }
}