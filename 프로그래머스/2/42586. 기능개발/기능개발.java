import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        int n = progresses.length;
        int[] left = new int[n];
        
        for(int i = 0; i < n; i++) {
            left[i] = (int) Math.ceil((100 - progresses[i])/(double) speeds[i]);
        }
                
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            if(q.isEmpty()) q.offer(left[i]);
            else {
                if(q.peek() >= left[i]) q.offer(left[i]);
                else {
                    list.add(q.size());
                    q.clear();
                    q.offer(left[i]);
                }
            }
        }
        if(!q.isEmpty()) list.add(q.size());
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}