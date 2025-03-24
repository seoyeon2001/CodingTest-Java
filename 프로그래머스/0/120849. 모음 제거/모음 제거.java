class Solution {
    public String solution(String my_string) {
        // String answer = my_string.replace("a", "");
        // answer = answer.replace("e", "");
        // answer = answer.replace("i", "");
        // answer = answer.replace("o", "");
        // answer = answer.replace("u", "");
        
        String answer = my_string.replaceAll("[aeiou]", "");
        return answer;
    }
}