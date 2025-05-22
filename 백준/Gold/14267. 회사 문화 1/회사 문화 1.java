import java.io.*;
import java.util.*;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parents = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dp[num] += w;
        }

        for (int i = 2; i <= n;  i++) {
            // 부모 찾기
            int parent = parents[i];
            dp[i] += dp[parent];
        }

        StringBuilder result = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            result.append(dp[i]).append(' ');
        }
        System.out.println(result);
    }
}
