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
    // 0: U, 1: D, 2: L, 3: R
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};

    // 반대 방향 인덱스
    private static final int[] reverse = {1, 0, 3, 2};

    public int solution(String dirs) {
        boolean[][][] visited = new boolean[11][11][4];

        int x = 0; int y = 0;
        int answer = 0;

        for (char command : dirs.toCharArray()) {
            int dir = getDirection(command);

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 경계 밖이면 무시
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

            int cx = x + 5;
            int cy = y + 5;
            int nnx = nx + 5;
            int nny = ny + 5;

            // 처음 지나가는 길이면 카운트
            if (!visited[cx][cy][dir])  answer++;

            // 양방향 방문 처리
            visited[cx][cy][dir] = true;
            visited[nnx][nny][reverse[dir]] = true;

            x = nx; y = ny;
        }

        return answer;
    }

    private int getDirection(char command) {
        switch (command) {
            case 'U': return 0;
            case 'D': return 1;
            case 'L': return 2;
            default:  return 3; // R
        }
    }
}