import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int x = 0;
        int y = 0;
        
        int calc = (brown - 4) / 2;
        
        for(int i = 1; i < calc; i++) {
            y = i;
            x = calc - y;
            
            if(x * y == yellow) break;
        }
        
        return new int[] {x+2, y+2};
    }
}