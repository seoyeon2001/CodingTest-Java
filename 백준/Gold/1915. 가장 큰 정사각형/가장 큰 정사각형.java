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

        // 누적합 구하기
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i-1][j-1];
            }
        }

//        System.out.println("dp = " + Arrays.deepToString(dp));

        int max = n > m ? n : m;
        int answer = 1;

        int size = 2;
        while(size <= max) {
            for(int i = size; i <= n; i++) {
                for(int j = size; j <= m; j++) {
                    int cnt = dp[i][j] - dp[i-size][j] - dp[i][j-size] + dp[i-size][j-size];
//                    System.out.println("cnt = " + cnt);
                    if(cnt == size*size) answer = Math.max(answer, cnt);
                }
            }
            size++;
        }

        System.out.println(answer);
    }
}
