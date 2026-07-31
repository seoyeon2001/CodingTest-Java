import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] one = {1, 2, 3, 4, 5}; // 5
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        
        int on = 0;
        int tw = 0;
        int th = 0;
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i%5]) on++;
            if(answers[i] == two[i%8]) tw++;
            if(answers[i] == three[i%10]) th++;
        }
        
        int max = Math.max(on, Math.max(tw, th));
        
        List<Integer> list = new ArrayList<>();
        if(on == max) list.add(1);
        if(tw == max) list.add(2);
        if(th == max) list.add(3);
        // System.out.println(list);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}