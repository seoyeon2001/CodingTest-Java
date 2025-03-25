import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) arrayList.add(i);
        }
        
        int[] answer = new int[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }
        
        return answer;
    }
}