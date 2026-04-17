// 14분
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        List<Integer> list = new ArrayList<>();
        
        int[] days = new int[progresses.length];
        for(int i = 0 ; i < progresses.length; i++) {
            int left = 100 - progresses[i];
            
            days[i] = left / speeds[i];
            
            if(left % speeds[i] != 0) days[i]++;
            
        }
        // System.out.println(Arrays.toString(days));
        
        Deque<Integer> q = new ArrayDeque<>();
        q.add(days[0]);
        
        for(int i = 1; i < days.length; i++) {
            if(days[i] <= q.peek()) {
                q.add(days[i]);
            } else {
                list.add(q.size());
                q.clear();
                q.add(days[i]);
            } 
        }
        list.add(q.size());
        
        // System.out.println(list);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}