import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] dp = new int[30][30];
        for(int i = 0; i < 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
            dp[i][1] = i;
        }

        for(int i = 3; i < 30; i++) {
            for(int j = 2; j < i; j++) {
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(dp[m][n]);
        }
    }
}
