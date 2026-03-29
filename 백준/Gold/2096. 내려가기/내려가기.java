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

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
//        System.out.println("arr = " + Arrays.deepToString(arr));

        int[][] max = new int[n][3];
        int[][] min = new int[n][3];
        for(int i = 0; i < 3; i++) {
            max[0][i] = arr[0][i];
            min[0][i] = arr[0][i];
        }
//        System.out.println("max = " + Arrays.deepToString(max));
//        System.out.println("min = " + Arrays.deepToString(min));

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                if(j == 0) {
                    max[i][j] = arr[i][j] + Math.max(max[i-1][j], max[i-1][j+1]);
                    min[i][j] = arr[i][j] + Math.min(min[i-1][j], min[i-1][j+1]);
                } else if(j == 1) {
                    max[i][j] = arr[i][j] + Math.max(max[i-1][j-1], Math.max(max[i-1][j], max[i-1][j+1]));
                    min[i][j] = arr[i][j] + Math.min(min[i-1][j-1], Math.min(min[i-1][j], min[i-1][j+1]));
                } else {
                    max[i][j] = arr[i][j] + Math.max(max[i-1][j-1], max[i-1][j]);
                    min[i][j] = arr[i][j] + Math.min(min[i-1][j-1], min[i-1][j]);
                }
            }
//            System.out.println("max = " + Arrays.deepToString(max));
//            System.out.println("min = " + Arrays.deepToString(min));
        }

        int maxAns = Integer.MIN_VALUE;
        int minAns = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            maxAns = Math.max(maxAns, max[n-1][i]);
            minAns = Math.min(minAns, min[n-1][i]);
        }
        System.out.println(maxAns + " " + minAns);
    }
}
