import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K+1];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            for(int j = K; j >= W; j--) {
//                if (dp[j] < dp[j-W]+V) dp[j] = dp[j-W]+V;
                dp[j] = Math.max(dp[j], dp[j-W]+V);
            }
        }
        int result = 0;
        for(int i = 0; i <= K; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }


}
