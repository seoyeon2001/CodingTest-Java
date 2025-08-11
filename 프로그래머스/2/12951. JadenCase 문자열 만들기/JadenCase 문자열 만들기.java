import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
//         StringBuffer sb = new StringBuffer();
//         boolean isNextSpace = true;
        
//         for(int i = 0; i < s.length(); i++) {
//             if(s.charAt(i) == ' ') {
//                 sb.append(" ");
//                 isNextSpace = true;
//             }
            
//             else if(isNextSpace) {
//                 if(Character.isLetter(s.charAt(i))) {
//                     sb.append(Character.toUpperCase(s.charAt(i)));
//                 } else {
//                     sb.append(s.charAt(i));
//                 }
//                 isNextSpace = false;
//             } 
            
//             else {
//                 sb.append(Character.toLowerCase(s.charAt(i)));
//             }
//         }
        
//         return sb.toString();
        
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        // System.out.println(Arrays.toString(sp));
        
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
    }
}