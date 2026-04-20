// 42분
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        boolean[] visited = new boolean[people.length];
        
        int left = 0;
        int right = people.length-1;
        
        while(left <= right) {
            if(people[left] + people[right] <= limit) {
                visited[left] = visited[right] = true;
                answer++;
                left++;
                right--;
            } else {
                right--;
            }
        }        
        
        for(int i = 0; i < people.length; i++) {
            if(!visited[i]) answer++;
        }
        return answer;
    }
}