import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        char[] dir = dirs.toCharArray();
        boolean[][][] visited = new boolean[12][12][4];
        
        int row = 0; int col = 0;
        for(char c : dir) {
            // System.out.println(c);
            // System.out.println(row + " " + col);
            
            if(c == 'U') {
                if(col + 1 > 5) continue;
                col += 1;
                
                if(!visited[row+5][col+5][1] && !visited[row+5][col+4][0]) answer++;
                
                visited[row+5][col+5][1] = true;
                visited[row+5][col+4][0] = true;
                
            } else if(c == 'D') {
                if(col - 1 < -5) continue;
                col -= 1;
                
                if(!visited[row+5][col+5][0] && !visited[row+5][col+6][1]) answer++;
                
                visited[row+5][col+5][0] = true;
                visited[row+5][col+6][1] = true;
                
            } else if(c == 'L') {
                if(row - 1 < -5) continue;
                row -= 1;
                
                if(!visited[row+5][col+5][3] && !visited[row+6][col+5][2]) answer++;
                
                visited[row+5][col+5][3] = true;
                visited[row+6][col+5][2] = true;
                
            } else {
                if(row + 1 > 5) continue;
                row += 1;
                
                if(!visited[row+5][col+5][2] && !visited[row+4][col+5][3]) answer++;
                
                visited[row+5][col+5][2] = true;
                visited[row+4][col+5][3] = true;
                
            }
            // System.out.println(row + " " + col);
        }
        return answer;
    }
}