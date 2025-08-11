import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuffer sb = new StringBuffer();
        boolean isNextSpace = true;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                sb.append(" ");
                isNextSpace = true;
            }
            
            else if(isNextSpace) {
                if(Character.isLetter(s.charAt(i))) {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                } else {
                    sb.append(s.charAt(i));
                }
                isNextSpace = false;
            } 
            
            else {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        
//         String[] tokens = s.split(" ");
//         StringBuffer sb = new StringBuffer();
//         // System.out.println(Arrays.toString(tokens));

//         for(String token : tokens) {
//            if(Character.isDigit(token.charAt(0))) {
//                sb.append(token.toLowerCase());
//            } else {
//                for (int i = 0; i < token.length(); i++) {
//                    if (i == 0) sb.append(Character.toUpperCase(token.charAt(i)));
//                    else sb.append(Character.toLowerCase(token.charAt(i)));
//                }
//            }
//             sb.append(" ");
//         }
//         sb = sb.substring(0, sb.length()-1);
        
        return sb.toString();
    }
}