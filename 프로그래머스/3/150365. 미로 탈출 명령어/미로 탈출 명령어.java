import java.util.*;

class Solution {
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};
    static String[] dir = {"d", "l", "r", "u"};
    
    static boolean isFound = false;
    static String result = "";
    
    // static List<String> list = new ArrayList<>();
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int enoughMove = Math.abs((x - r)) + Math.abs((y - c));
        
        if (enoughMove > k) { // 움직여야 하는 횟수보다 k가 작다면 탈출 불가
            return "impossible";
        }
        
        int restMove = k - enoughMove;
        
        if (restMove % 2 != 0) { // 남은 움직임이 홀수이면 탈출 불가
            return "impossible";
        }
        
        backtracking(n, m, k, r-1, c-1, 0, x-1, y-1, new StringBuilder());
        
        // System.out.println(list);
        // System.out.println(list.size());
        
        // Collections.sort(list);
        // System.out.println(list);
        
        // return list.get(0);
        return result;
    }
    
    static void backtracking(int n, int m, int k, int goalr, int goalc, int depth, int cr, int cc, StringBuilder answer) {
        // System.out.println("cr: " + cr + " cc: " + cc + " depth: " + depth);
        
        if (isFound) return;
        
        // 남은 거리로 도달할 수 없는 경우
        int remainDist = Math.abs(goalr - cr) + Math.abs(goalc - cc);
        if (remainDist > k - depth) return;
        
        if (depth == k) {
            // System.out.println("cr: " + cr + " cc: " + cc);
            if (cr == goalr && cc == goalc) {
                // System.out.println("들어옴");
                // list.add(answer.toString());
                result = answer.toString();
                isFound = true;
            }
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            int nr = cr + dr[i];
            int nc = cc + dc[i];
            // System.out.println("=== nr: " + nr + " nc: " + nc);

            if (0 > nr || nr >= n || 0 > nc || nc >= m) continue; // 범위를 벗어남
            
            answer.append(dir[i]);
            
            backtracking(n, m, k, goalr, goalc, depth+1, nr, nc, answer);
            
            answer.delete(answer.length()-1, answer.length());
        }
    }
}