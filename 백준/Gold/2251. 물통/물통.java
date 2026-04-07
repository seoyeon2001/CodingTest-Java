import java.io.*;
import java.util.*;

public class Main {
    static int[] bucket = new int[3];
    static List<Integer> answer = new ArrayList<>();
    static int[] now = new int[3];
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        bucket[0] = Integer.parseInt(st.nextToken());
        bucket[1] = Integer.parseInt(st.nextToken());
        bucket[2] = Integer.parseInt(st.nextToken());

        visited = new boolean[bucket[0]+1][bucket[1]+1];
        now[2] = bucket[2];

        dfs(now);

        Collections.sort(answer);

        for(int i : answer) {
            System.out.print(i+ " ");
        }
    }

    static void dfs(int[] now) {
        visited[now[0]][now[1]] = true;

        // 원본 복사
        int[] copy = new int[3];
        copy[0] = now[0]; copy[1] = now[1]; copy[2] = now[2];

        if(now[0] == 0) answer.add(now[2]);

        for(int i = 0; i < 3; i++) {
            if(now[i] == 0) continue;

            now[(i + 1) % 3] += now[i];
            now[i] = 0;
            if(now[(i + 1) % 3] > bucket[(i + 1) % 3]) {
                now[i] = now[(i + 1) % 3] - bucket[(i + 1) % 3];
                now[(i + 1) % 3] = bucket[(i + 1) % 3];
            }

            if(!visited[now[0]][now[1]]) {
                dfs(now);
            }

            now[0] = copy[0]; now[1] = copy[1]; now[2] = copy[2];

            now[(i + 2) % 3] += now[i];
            now[i] = 0;
            if(now[(i + 2) % 3] > bucket[(i + 2) % 3]) {
                now[i] = now[(i + 2) % 3] - bucket[(i + 2) % 3];
                now[(i + 2) % 3] = bucket[(i + 2) % 3];
            }

            if(!visited[now[0]][now[1]]) {
                dfs(now);
            }
        }
    }
}
