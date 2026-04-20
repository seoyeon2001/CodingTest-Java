import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        boolean[] visited = new boolean[people.length];
//         for(int i = 0; i < people.length; i++) {
//             for(int j = people.length-1; j >= 0; j--) {
//                 System.out.println(i + " " + j);
                
//                 if(!visited[i] && !visited[j] && people[i] + people[j] <= limit) {
//                     visited[i] = visited[j] = true;
//                     answer++;
//                     break;
//                 }
                
//                 if(i == j) {
//                     visited[i] = true;
//                     answer++;
//                     break;
//                 }
//             }
//         }
        
        int left = 0;
        int right = people.length-1;
        
        while(left < right) {
            if(people[left] + people[right] <= limit) {
                visited[left] = visited[right] = true;
                answer++;
                left++;
                right--;
            } else {
                right--;
            }
        }
        
        // answer += people.length - left - 1;
        for(int i = 0; i < people.length; i++) {
            if(!visited[i]) answer++;
        }
        return answer;
    }
}