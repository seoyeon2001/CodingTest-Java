import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        select();

        // 출력
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
    // 선택 정렬 O(n^2)
    static void select() {
        for(int start = 0; start < n-1; start++) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int i = start; i < n; i++) {
                if(arr[i] < min) {
                    min = arr[i];
                    minIdx = i;
                }
            }

            int temp = arr[start];
            arr[start] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}
