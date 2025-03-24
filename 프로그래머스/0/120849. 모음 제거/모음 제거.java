class Solution {
    public String solution(String my_string) {
        
        // // 방법 1
        String answer = my_string.replace("a", "");
        answer = answer.replace("e", "");
        answer = answer.replace("i", "");
        answer = answer.replace("o", "");
        answer = answer.replace("u", "");
        
        // // 방법 2
        // String answer = my_string.replaceAll("[aeiou]", "");
        
        // 방법 3
        // String answer = my_string.replaceAll("a|e|i|o|u", "");
        return answer;
    }
}