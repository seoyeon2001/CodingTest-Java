// // 45분
// import java.util.*;

// class Solution {
//     public int solution(String dirs) {
//         int answer = 0;
        
//         char[] dir = dirs.toCharArray();
//         boolean[][][] visited = new boolean[12][12][4];
        
//         int row = 0; int col = 0;
//         for(char c : dir) {
            
//             if(c == 'U') {
//                 if(col + 1 > 5) continue;
//                 col += 1;
                
//                 if(!visited[row+5][col+5][1] && !visited[row+5][col+4][0]) answer++;
                
//                 visited[row+5][col+5][1] = true;
//                 visited[row+5][col+4][0] = true;
                
//             } else if(c == 'D') {
//                 if(col - 1 < -5) continue;
//                 col -= 1;
                
//                 if(!visited[row+5][col+5][0] && !visited[row+5][col+6][1]) answer++;
                
//                 visited[row+5][col+5][0] = true;
//                 visited[row+5][col+6][1] = true;
                
//             } else if(c == 'L') {
//                 if(row - 1 < -5) continue;
//                 row -= 1;
                
//                 if(!visited[row+5][col+5][3] && !visited[row+6][col+5][2]) answer++;
                
//                 visited[row+5][col+5][3] = true;
//                 visited[row+6][col+5][2] = true;
                
//             } else {
//                 if(row + 1 > 5) continue;
//                 row += 1;
                
//                 if(!visited[row+5][col+5][2] && !visited[row+4][col+5][3]) answer++;
                
//                 visited[row+5][col+5][2] = true;
//                 visited[row+4][col+5][3] = true;
                
//             }
//         }
//         return answer;
//     }
// }

import java.util.*;

class Solution {

    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();

        int x = 0; int y = 0;
        for (char dir : dirs.toCharArray()) {
            int nx = x; int ny = y;

            switch (dir) {
                case 'U': ny++; break;
                case 'D': ny--; break;
                case 'R': nx++; break;
                case 'L': nx--; break;
            }

            // 경계 밖이면 무시
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }

            // 양방향 동일한 길 처리            
            String path = x + "," + y + "->" + nx + "," + ny;
            String reversePath = nx + "," + ny + "->" + x + "," + y;

            visited.add(path);
            visited.add(reversePath);

            x = nx; y = ny;
        }

        return visited.size() / 2;
    }
}