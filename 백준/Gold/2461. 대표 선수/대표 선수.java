import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N*M][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[M*i+j][0] = Integer.parseInt(st.nextToken());
                arr[M*i+j][1] = i;
            }
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int left = 0, right = 0;
        int[] cnt = new int[N];
        int count = 1;
        cnt[arr[0][1]] = 1;

        int min = Integer.MAX_VALUE;
        while(left <= right) {
            if(count == N) {
                min = Math.min(min, arr[right][0] - arr[left][0]);
                if(cnt[arr[left][1]] == 1) count--;
                cnt[arr[left][1]]--;
                left++;
            } else {
                right++;
                if(right == N*M) break;
                if(cnt[arr[right][1]] == 0) count++;
                cnt[arr[right][1]]++;
            }


        }
        System.out.println(min);
    }
}
