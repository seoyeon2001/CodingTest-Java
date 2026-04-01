import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] tArr = new int[n+1];
        int[] pArr = new int[n+1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            tArr[i] = Integer.parseInt(st.nextToken());
            pArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+2];

        for(int i = n; i > 0; i--) {
            if(i + tArr[i] - 1 > n) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(pArr[i] + dp[i+tArr[i]], dp[i+1]);
            }
        }
//        System.out.println(Arrays.toString(dp));

        System.out.println(dp[1]);

    }
}
