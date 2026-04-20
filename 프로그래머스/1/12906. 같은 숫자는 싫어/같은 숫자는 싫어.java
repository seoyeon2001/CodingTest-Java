/*
// 4분
import java.util.*;
public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> result = new ArrayList<>();
        
        result.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i-1] != arr[i]) {
                result.add(arr[i]);
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
*/

// 4분
import java.util.*;
public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(arr[0]);
        
        for(int i = 1; i < arr.length; i++) {
            if(q.peekLast() != arr[i]) {
                q.addLast(arr[i]);
            }
        }
        
        int[] answer = new int[q.size()];
        int idx = 0;
        while(!q.isEmpty()) {
            answer[idx++] = q.pollFirst();
        }
        
        return answer;
    }
}

