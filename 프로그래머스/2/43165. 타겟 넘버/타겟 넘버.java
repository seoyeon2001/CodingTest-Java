// 25분
import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {        
        dfs(-numbers[0], 0, numbers, target);
        // System.out.println("-------------------------");
        dfs(numbers[0], 0, numbers, target);
        
        return answer;
    }
    
    static void dfs(int num, int depth, int[] numbers, int target) {
        // System.out.println(depth + " " + num);
        if(depth == numbers.length-1) {
            if(num == target) answer++;
            return;
        }
        
        dfs(num - numbers[depth+1], depth+1, numbers, target);
        dfs(num + numbers[depth+1], depth+1, numbers, target);
    }
}