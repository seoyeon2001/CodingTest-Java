import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            arr[i][0] = color; arr[i][1] = size; arr[i][2] = i;
        }

        Arrays.sort(arr, Comparator.comparing(o -> o[1])); // size로 정렬

        int[] answer = new int[n];
        int[] colorSum = new int[200001];
        int totalSum = 0;

        int idx = 0;
        for (int i = 0; i < n; i++) {
            int curColor = arr[i][0], curSize = arr[i][1];

            while (arr[idx][1] < curSize) {
                int color = arr[idx][0], size = arr[idx][1];
                totalSum += size;
                colorSum[color] += size;
                idx++;
            }

            answer[arr[i][2]] = totalSum - colorSum[curColor];
        }
        
        for(int ans : answer) {
            System.out.println(ans);
        }
    }
}
