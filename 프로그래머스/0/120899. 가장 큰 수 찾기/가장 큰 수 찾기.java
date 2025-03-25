class Solution {
    public int[] solution(int[] array) {
        
        int max_num = 0;
        int max_idx = 0;
        
        for(int i = 0; i < array.length; i++) {
            if (array[i] > max_num) {
                max_num = array[i];
                max_idx = i;
            }
        }
        
        int[] answer = {max_num, max_idx};
        
        return answer;
    }
}