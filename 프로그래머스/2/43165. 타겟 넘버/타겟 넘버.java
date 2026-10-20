import java.util.*;

class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers, target, 0, numbers[0]);
        dfs(numbers, target, 0, -numbers[0]);
        return answer;
    }
    
    private void dfs(int[] numbers, int target, int depth, int sum) {
        if(depth == numbers.length-1) {
            // System.out.println(sum);
            if(sum == target) answer++;
            return;
        }
        
        dfs(numbers, target, depth+1, sum + numbers[depth+1]);
        dfs(numbers, target, depth+1, sum - numbers[depth+1]);
    }
}