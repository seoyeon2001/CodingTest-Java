import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2차원 누적합 배열 만들기
        int[][] sumMap = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                sumMap[i][j] = sumMap[i-1][j] + sumMap[i][j-1] - sumMap[i-1][j-1] + map[i-1][j-1];
            }
        }

//        System.out.println("sumMap = " + Arrays.deepToString(sumMap));

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int answer = sumMap[x2][y2] - sumMap[x1-1][y2] - sumMap[x2][y1-1] + sumMap[x1-1][y1-1];
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}