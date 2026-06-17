// import java.util.*;

// class Solution {
//     public String solution(String s) {
//         String answer = "";
//         String[] arr = s.split(" ");
 
//         for(int i = 0; i < arr.length; i++) {
//             String word = arr[i];
 
//             if(word.length() == 0) {
//                 answer += " ";
//             } else {
//                 answer += word.substring(0, 1).toUpperCase();
//                 answer += word.substring(1, word.length()).toLowerCase();
//                 answer += " ";
//             }
//         }
        
//         if(s.substring(s.length() - 1, s.length()).equals(" ")){
//             return answer;
//         }
        
//         return answer.substring(0, answer.length() - 1);
//     }
// }

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.toLowerCase().split("");
        
        boolean isFirst = true;
        for(String word : words) {
            answer += isFirst ? word.toUpperCase() : word;
            isFirst = word.equals(" ") ? true : false;
        }

        return answer;
  }
}