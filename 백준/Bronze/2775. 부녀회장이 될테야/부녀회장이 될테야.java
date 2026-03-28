import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int[][] dp = new int[15][15];
        for(int i = 0; i <= 14; i++) {
            dp[0][i] = i; // 0층
            dp[i][1] = 1; // 1호
        }

        for(int i = 1; i <= 14; i++) {
            for(int j = 2; j <= 14; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        while(t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(dp[k][n]);
        }

    }
}
