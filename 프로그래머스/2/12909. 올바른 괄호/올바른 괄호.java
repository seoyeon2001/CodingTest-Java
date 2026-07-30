import java.util.*;

class Solution {
    boolean solution(String s) {

        char[] c = s.toCharArray();
        // System.out.println(Arrays.toString(c));
        
        Stack<Character> stack = new Stack<>();
        for(char cc : c) {
            if(cc == '(') stack.push(cc);
            else {
                if(stack.isEmpty()) return false;
                
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()) return false;

        return true;
    }
}