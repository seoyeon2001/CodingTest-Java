import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] arr;
    static int[][] minScore;
    static int n;

    static class Node implements Comparable<Node> {
        int r, c, score;
        Node(int r, int c, int score) {
            this.r = r;
            this.c = c;
            this.score = score;
        }

        @Override
        public int compareTo(Node o) {
            return this.score - o.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            idx++;

            arr = new int[n][n];
            minScore = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    minScore[i][j] = Integer.MAX_VALUE;
                }
            }

            dijkstra();
            sb.append(String.format("Problem %d: %d", idx, minScore[n-1][n-1])).append("\n");
        }

        System.out.print(sb);
    }

    static void dijkstra() {
        Queue<Node> q = new PriorityQueue<>();
        minScore[0][0] = arr[0][0];
        q.add(new Node(0, 0, arr[0][0]));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.score > minScore[cur.r][cur.c]) continue;

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i], nc = cur.c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                int newScore = cur.score + arr[nr][nc];
                if (newScore < minScore[nr][nc]) {
                    minScore[nr][nc] = newScore;
                    q.add(new Node(nr, nc, newScore));
                }
            }
        }
    }
}
