import java.io.*;
import java.util.*;

public class Main {
    // 케이스 저장
    static int[] from = {0, 0, 1, 1, 2, 2};
    static int[] to = {1, 2, 0, 2, 0, 1};

    static int[] bucket = new int[3];
    static boolean visited[][];
    static boolean answer[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        bucket[0] = Integer.parseInt(st.nextToken());
        bucket[1] = Integer.parseInt(st.nextToken());
        bucket[2] = Integer.parseInt(st.nextToken());

        visited = new boolean[201][201];
        answer = new boolean[201];

        bfs();

        for(int i = 0; i < 201; i++){
            if(answer[i]) System.out.print(i + " ");
        }
    }
    
    static void bfs() {
        Deque<AB> q = new ArrayDeque<>();
        
        visited[0][0] = true;
        q.add(new AB(0, 0));
        answer[bucket[2]] = true;
        
        while(!q.isEmpty()) {
            AB ab = q.poll();
            
            int a = ab.A, b = ab.B, c = bucket[2]-a-b;
            
            for(int i = 0; i < 6; i++) {
                int[] next = {a, b, c};
                next[to[i]] += next[from[i]];
                next[from[i]] = 0;
                
                // 물이 넘치면
                if(next[to[i]] > bucket[to[i]]) {
                    
                    // 다시 넣어줌
                    next[from[i]] = next[to[i]] - bucket[to[i]];
                    next[to[i]] = bucket[to[i]];
                }
                
                if(!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.add(new AB(next[0], next[1]));
                    
                    if(next[0] == 0) answer[next[2]] = true;
                }
            }
        }
    }
    
    static class AB {
        int A;
        int B;
        
        AB(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }
}
