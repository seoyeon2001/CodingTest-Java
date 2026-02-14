import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(st.nextToken()); // 10만 미만
        int m = Integer.parseInt(st.nextToken()); // 10만 미만

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 누적 합
        int[] sum = new int[n+1];
        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + arr[i-1];
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