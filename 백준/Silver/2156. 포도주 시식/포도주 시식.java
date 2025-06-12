import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
//        System.out.println(Arrays.toString(arr));

        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }
        else if (n == 2) {
            System.out.println(arr[0] + arr[1]);
            return;
        }
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(Math.max(arr[0] + arr[1], arr[0] + arr[2]), arr[1] + arr[2]);

        for(int i = 3; i < n; i++){
            int a = dp[i-1]; // 내가 안 먹을 때
            int b = dp[i-2] + arr[i]; // 내가 먹는데 내 앞에 안 먹으면
            int c = arr[i] + arr[i-1] + dp[i-3]; // 나랑 내 앞에가 먹으면

            dp[i] = Math.max(Math.max(a, b), c);
        }

        System.out.println(dp[n-1]);
    }
}
