import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxBox = Integer.parseInt(br.readLine());

        int[] sumArr = new int[n+1];
        for(int i = 1; i <= n; i++) {
            sumArr[i] = sumArr[i-1] + arr[i-1];
        }

//        System.out.println("sumArr = " + Arrays.toString(sumArr));

        // 박스 선택
        int[] dp = new int[n];
        for(int i = maxBox-1; i < n; i++) { // i = 1 ~ 6
            dp[i] = sumArr[i+1] - sumArr[i+1-maxBox];
        }
//        System.out.println("dp = " + Arrays.toString(dp));

        int[][] answer = new int[3][n];

        // 기차 1개
        for(int i = maxBox-1; i < n; i++) {
            answer[0][i] = Math.max(answer[0][i-1], dp[i]);
        }
//        System.out.println("기차 1개 = " + Arrays.toString(answer[0]));

        // 기차 2개
        for(int i = maxBox*2-1; i < n; i++) {
            answer[1][i] = Math.max(answer[1][i-1], answer[0][i-maxBox] + dp[i]);
        }
//        System.out.println("기차 2개 = " + Arrays.toString(answer[1]));

        // 기차 3개
        for(int i = maxBox*3-1; i < n; i++) {
            answer[2][i] = Math.max(answer[2][i-1], answer[1][i-maxBox] + dp[i]);
        }
//        System.out.println("기차 3개 = " + Arrays.toString(answer[2]));

        System.out.println(answer[2][n-1]);
    }
}
