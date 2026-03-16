import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] cnt;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 색종이 개수 저장
        cnt = new int[6];
        Arrays.fill(cnt, 5);

        map = new int[10][10];
        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void dfs(int r, int c, int total) {

        if(total >= answer) return;

        if(c == 10) {
            dfs(r + 1, 0, total);
            return;
        }

        if(r == 10) {
            answer = Math.min(answer, total);
            return;
        }

        if(map[r][c] == 0) {
            dfs(r, c + 1, total);
            return;
        }

        for(int size = 5; size > 0; size--) { // 사이즈가 큰 것부터 확인하기

            // 색종이의 개수가 초과되지 않는가
            if(cnt[size] == 0) continue;

            if(check(r, c, size)) { // 붙일 수 있는 경우
                attach(r, c, size, 0);
                cnt[size]--;

                dfs(r, c+size, total+1);

                attach(r, c, size, 1);
                cnt[size]++;
            }
        }

    }

    // 색종이를 붙일 수 있는지 체크
    static boolean check(int r, int c, int size) {

        // 범위를 벗어나지 않는가
        if(r+size > 10 || c+size > 10) return false;

        // 영역이 다 1인가
        for(int i = r; i < r+size; i++) {
            for(int j = c; j < c+size; j++) {
                if(map[i][j] == 0) return false;
            }
        }

        return true;
    }

    static void attach(int r, int c, int size, int value) {

        for(int i = r; i < r+size; i++) {
            for(int j = c; j < c+size; j++) {
                map[i][j] = value;
            }
        }
    }
}
