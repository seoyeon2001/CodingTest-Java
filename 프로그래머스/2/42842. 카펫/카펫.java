class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        /*
        2a + 2b = brown + 4
        a + b = brown/2 + 2
        */
        for (int a = 1; a < brown/2 + 2; a++) {
            int b = brown/2 + 2 - a;
            
            if ((a-2) * (b-2) == yellow) {
                if (a > b) {
                    answer[0] = a;
                    answer[1] = b;
                } else {
                    answer[0] = b;
                    answer[1] = a;
                }
                
                break;
            }
        }
        return answer;
    }
}