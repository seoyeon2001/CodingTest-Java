import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr[i]);
        }

        int[] nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = arr[i][0];
        }
        int[] numsIdx = new int[N];

        int answer = Integer.MAX_VALUE;

        for (int time = 0; time < N*(M-1); time++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int minIdx = -1;

            for(int i = 0; i < N; i++) {
                if(nums[i] <= min) {
                    min = nums[i];
                    minIdx = i;
                }
                max = Math.max(max, nums[i]);
            }
            answer = Math.min(answer, max - min);
            numsIdx[minIdx]++;
            if(numsIdx[minIdx] == M) break;
            nums[minIdx] = arr[minIdx][numsIdx[minIdx]];
        }

        System.out.println(answer);
    }
}