import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {        
        ArrayList<Integer> num_arraylist = new ArrayList<>();
        
        for(int num : numlist) {
            if (num % n == 0) num_arraylist.add(num);
        }
        
        int[] answer = new int[num_arraylist.size()];
        for (int i = 0; i < num_arraylist.size(); i++){
            answer[i] = num_arraylist.get(i);
        } 
        
        return answer;
    }
}