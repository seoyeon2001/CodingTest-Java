import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        
        int[] one = {1, 2, 3, 4, 5}; // 5
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        
        for(int i = 0; i < answers.length; i++) {
            int correct = answers[i];
            
            if(correct == one[i%5]) answer[0]++;
            if(correct == two[i%8]) answer[1]++;
            if(correct == three[i%10]) answer[2]++;
        }
        
        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(answer[i] == max) list.add(i+1);
        }
        
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}