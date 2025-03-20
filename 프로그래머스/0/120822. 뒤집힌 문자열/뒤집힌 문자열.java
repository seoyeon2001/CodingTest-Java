// 방법 1
/*
class Solution {
    public String solution(String my_string) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            answer += my_string.substring(my_string.length() - i - 1, my_string.length() - i);
        }
        return answer;
    }
}
*/

// 방법 2
/*
import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        sb.append(my_string);
        sb.reverse();

        return sb.toString();
    }
}
*/

// 방법 3
class Solution {
    public String solution(String my_string) {
        String answer = "";

        for(int i = my_string.length() -1; i >= 0; i--){
            answer += my_string.charAt(i);
        }

        return answer;
    }
}