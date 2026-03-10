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

        insertion();

        // 출력
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    // 삽입 정렬 O(n^2)
    static void insertion() {
        for(int i = 1; i < n; i++) {
            int num = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > num) {
                arr[j+1] = arr[j]; // shift
                j--;
            }
            arr[j+1] = num;
        }
    }
}
