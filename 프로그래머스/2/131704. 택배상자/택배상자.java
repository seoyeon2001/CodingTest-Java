import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Deque<Integer> mainQueue = new ArrayDeque<>();
        for(int i = 1; i <= order.length; i++) {
            mainQueue.addLast(i);
        }
        Deque<Integer> subStack = new ArrayDeque<>();
        
        int turn = order[answer];
        while(!subStack.isEmpty() || !mainQueue.isEmpty()) {
            if(!mainQueue.isEmpty() && turn == mainQueue.peek()) {
                mainQueue.poll();
                answer++;
                if(answer == order.length) break;
                turn = order[answer];
            } else if(!subStack.isEmpty() && turn == subStack.peek()) {
                subStack.pop();
                answer++;
                if(answer == order.length) break;
                turn = order[answer];
            } else {
                if(!mainQueue.isEmpty()) {
                    subStack.push(mainQueue.poll());
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}