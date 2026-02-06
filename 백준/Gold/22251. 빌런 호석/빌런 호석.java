import java.io.*;
import java.util.*;

public class Main {
    static int[][] numbers = new int[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        setting();

        int n = Integer.parseInt(arr[0]); int k = Integer.parseInt(arr[1]);
        int p = Integer.parseInt(arr[2]); int x = Integer.parseInt(arr[3]);

        int answer = 0;

        int[] targetArr = new int[k];
        toDigits(x, targetArr, k);

        for(int i = 1; i <= n; i++) {
            if(i == x) continue;

            int[] curArr = new int[k];
            toDigits(i, curArr, k);

            int cnt = 0;
            for(int j = 0; j < k; j++) {
                int a = targetArr[j];
                int b = curArr[j];

                if(a == b) continue;

                cnt += numbers[a][b];
                if (cnt > p) break;
            }

            if(cnt <= p) answer++;
        }
        System.out.println(answer);
    }

    static void toDigits(int num, int[] arr, int k) {
        for(int i = k - 1; i >= 0; i--) {
            arr[i] = num % 10;
            num /= 10;
        }
    }

    public static void setting() {
        numbers[0] = new int[]{0, 4, 3, 3, 4, 3, 2, 3, 1, 2};
        numbers[1] = new int[]{4, 0, 5, 3, 2, 5, 6, 1, 5, 4};
        numbers[2] = new int[]{3, 5, 0, 2, 5, 4, 3, 4, 2, 3};
        numbers[3] = new int[]{3, 3, 2, 0, 3, 2, 3, 2, 2, 1};
        numbers[4] = new int[]{4, 2, 5, 3, 0, 3, 4, 3, 3, 2};
        numbers[5] = new int[]{3, 5, 4, 2, 3, 0, 1, 4, 2, 1};
        numbers[6] = new int[]{2, 6, 3, 3, 4, 1, 0, 5, 1, 2};
        numbers[7] = new int[]{3, 1, 4, 2, 3, 4, 5, 0, 4, 3};
        numbers[8] = new int[]{1, 5, 2, 2, 3, 2, 1, 4, 0, 1};
        numbers[9] = new int[]{2, 4, 3, 1, 2, 1, 2, 3, 1, 0};
    }
}
