class Solution {
    public int solution(int num, int k) {
//         int answer = -1;
//         String num_string = Integer.toString(num);
        
//         for (int i = 0; i < num_string.length(); i++) {            
//             if (Character.getNumericValue(num_string.charAt(i)) == k) return i+1;
//         }
        
//         return answer;
        return (" " + num).indexOf(String.valueOf(k));
    }
}