import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(st.nextToken()); // 10만 미만
        int m = Integer.parseInt(st.nextToken()); // 10만 미만

        // 누적 합
        st = new StringTokenizer(br.readLine());
        int[] sum = new int[n+1];
        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());

            int answer = sum[idx2] - sum[idx1-1];
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}