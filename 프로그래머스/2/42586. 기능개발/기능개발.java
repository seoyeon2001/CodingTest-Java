import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++) {
            int left = 100 - progresses[i];
            
            int days = left / speeds[i];
            
            if(left % speeds[i] != 0) days++;
            
            q.add(days);
        }
        
        List<Integer> list = new ArrayList<>();
        int now = q.poll();
        int cnt = 1;
        
        while(!q.isEmpty()) {      
            if(now >= q.peek()) {
                q.poll();
                cnt++;
            } else {
                list.add(cnt);
                now = q.poll();
                cnt = 1;
            }
        }
        
        list.add(cnt);
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}