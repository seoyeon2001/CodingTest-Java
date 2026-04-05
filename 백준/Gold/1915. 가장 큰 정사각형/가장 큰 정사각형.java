import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int oneCnt = 0;
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                int number = input[j] - '0';
                arr[i][j] = number;
                oneCnt += number;
            }
        }

        if(oneCnt == 0) {
            System.out.println(0);
            return;
        }

        int[][] dp = new int[n][m];
        for(int i = 0; i < m; i++) {
            dp[0][i] = arr[0][i];
        }

        for(int i = 0; i < n; i++) {
            dp[i][0] = arr[i][0];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
    //            System.out.println("왼 = " + dp[i][j-1] + " 위 = " + dp[i-1][j] + " 대 = " + dp[i-1][j-1]);
                if(arr[i][j] == 0) continue;
                
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
            }
        }

        int answer = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }
        System.out.println(answer*answer);
    }
}