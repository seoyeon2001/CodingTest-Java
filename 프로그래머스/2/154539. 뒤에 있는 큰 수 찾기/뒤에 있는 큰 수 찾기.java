import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Deque<int[]> stack = new ArrayDeque<>();
        
        for(int i = 0; i < numbers.length; i++) {
            int cntNum = numbers[i];
            
            while(!stack.isEmpty() && cntNum > stack.peek()[1]) {
                int[] top = stack.pop();
                answer[top[0]] = cntNum;
            }
            
            stack.push(new int[] {i, cntNum});
        }
        
        return answer;
    }
}