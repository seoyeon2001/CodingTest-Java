import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        
        ArrayList<Integer> answer_arraylist = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) answer_arraylist.add(i);
        }
        
        int[] answer = answer_arraylist.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}