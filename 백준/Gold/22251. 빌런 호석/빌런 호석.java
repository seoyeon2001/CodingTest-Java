import java.io.*;
import java.util.*;

public class Main {
    static int[][] numbers = new int[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        setting2();

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
        for(int i = k-1; i >= 0; i--) {
            arr[i] = num % 10;
            num /= 10;
        }
    }

    public static void setting2() {
        int[] bit = new int[10];
        bit[0] = 0b1111110;
        bit[1] = 0b0110000;
        bit[2] = 0b1101101;
        bit[3] = 0b1111001;
        bit[4] = 0b0110011;
        bit[5] = 0b1011011;
        bit[6] = 0b1011111;
        bit[7] = 0b1110000;
        bit[8] = 0b1111111;
        bit[9] = 0b1111011;

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < i+1; j++) {
                if(i == j) continue;
                int cnt = Integer.bitCount(bit[i] ^ bit[j]);

                numbers[i][j] = cnt;
                numbers[j][i] = cnt;
            }
        }
    }
}
