// class Solution {
//     public String solution(String my_string) {
//         String answer = "";
//         for (int i = 0; i < my_string.length(); i++) {
//             answer += my_string.substring(my_string.length() - i - 1, my_string.length() - i);
//         }
//         return answer;
//     }
// }

import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        sb.append(my_string);
        sb.reverse();

        return sb.toString();
    }
}