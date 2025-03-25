class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        // // 방법 1
        // for(char ch: my_string.toCharArray()) {
        //     if(Character.isDigit(ch)) answer += ch - '0';
        // }
        
        // 방법 2
        String str = my_string.replaceAll("[^0-9]","");

        for(char ch : str.toCharArray()) {
            answer += Character.getNumericValue(ch);
        }

        return answer;
    }
}