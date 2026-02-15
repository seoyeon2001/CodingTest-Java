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

        // 앞에서부터 박스 선택
        int[] frontBoxSum = new int[n];
        for(int i = maxBox-1; i < n; i++) {
            frontBoxSum[i] = sumArr[i+1] - sumArr[i+1-maxBox];
        }

        // 뒤에서부터 박스 선택
        int[] backBoxSum = new int[n];
        for(int i = n-maxBox; i >= 0; i--) {
            backBoxSum[i] = sumArr[i+maxBox] - sumArr[i];
        }

        // front
        int[] frontDp = new int[n];
        for(int i = 1; i < n; i++) {
            frontDp[i] = Math.max(frontDp[i-1], frontBoxSum[i]);
        }

        // back
        int[] backDp = new int[n];
        for(int i = n-2; i >= 0; i--) {
            backDp[i] = Math.max(backDp[i+1], backBoxSum[i]);
        }

        int answer = 0;

        // i = 중간
        for(int i = maxBox*2-1; i < n - maxBox; i++) {
            int mid = frontBoxSum[i];

            // 앞 열차
            int front = frontDp[i-maxBox];

            // 뒤 열차
            int back = backDp[i+1];

            answer = Math.max(answer, front + back + mid);
        }

        System.out.println(answer);
    }
}