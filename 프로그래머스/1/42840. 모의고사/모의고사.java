import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5}; // 5
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        
        int A = 0;
        int B = 0;
        int C = 0;
        for(int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            
            if(answer == one[i%5]) A++;
            if(answer == two[i%8]) B++;
            if(answer == three[i%10]) C++;
        }
        // System.out.println(A + " " + B + " " + C);
        int max = Math.max(A, Math.max(B, C));
        
        List<Integer> list = new ArrayList<>();
        if(A == max) list.add(1);
        if(B == max) list.add(2);
        if(C == max) list.add(3);
        
        // System.out.println(list);
        
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}