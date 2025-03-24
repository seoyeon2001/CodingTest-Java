import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {        
        ArrayList<Integer> num_arraylist = new ArrayList<>();
        
        for(int num : numlist) {
            if (num % n == 0) num_arraylist.add(num);
        }
        
        int[] answer = num_arraylist.stream().mapToInt(Integer::intValue).toArray();        
        // int[] answer = new int[a.size()];
        // for (int i=0;i<a.size();i++){
        //     answer[i]=a.get(i);
        // } 
        
        return answer;
    }
}