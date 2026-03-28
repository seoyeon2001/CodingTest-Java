import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
            dp[i][1] = i;
        }

        for(int i = 3; i <= n; i++) {
            for(int j = 2; j < i; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % 10007;
            }
        }

        System.out.println(dp[n][r] % 10007);
    }
}
