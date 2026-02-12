import java.io.*;
import java.util.*;

public class Main {

    public static int n, m, r, c;
    public static int[][] map;
    public static int dir;

    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static int answer = 2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map[r][c] = answer;
        sol(r, c, dir);

        System.out.println(answer-1);
    }

    // 청소해야 하는가?
    public static boolean isNeedClean(int r, int c) {
        if(map[r][c] == 0) return true;
        else return false;
    }

    public static void sol(int r, int c, int dir) {
        // 이동 가능
        for(int i = 0; i < 4; i++) { // 4번 체크
            dir = (dir+3) % 4; // 반시계 방향
            int nr = r + dr[dir], nc = c + dc[dir]; // 다음 이동 위치

            if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue; // 범위 벗어나면 무시

            if(isNeedClean(nr, nc)) {
                answer++;
                map[nr][nc] = answer;
                sol(nr, nc, dir);
                return;
            }
        }

        // 이동 불가 -> 후진해야 함
        int br = r - dr[dir];
        int bc = c - dc[dir];
        if(br >= 0 && br < n && bc >= 0 && bc < m) {
            if(map[br][bc] != 1) { // 벽이 아니면
                sol(br, bc, dir);
            }
        }
    }
}
