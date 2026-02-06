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

        String target = String.format("%0" + k + "d", x);
        for(int i = 1; i <= n; i++) {
            String format = "%0" + k + "d";
            String number = String.format(format, i);
//            System.out.println("number = " + number);

            int cnt = 0;
            if(target.equals(number)) continue;

            for(int j = 0; j < k; j++) {
                int a = target.charAt(j) - '0';
                int b = number.charAt(j) - '0';

                if(a == b) continue;

                cnt += numbers[a][b];
                if (cnt > p) break;
            }

            if(cnt <= p) answer++;

        }
        System.out.println(answer);
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
