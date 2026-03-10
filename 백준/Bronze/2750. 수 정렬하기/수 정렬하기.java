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

        quick(0, n-1);

        // 출력
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    // 퀵 정렬 O(nlogn)
    static void quick(int left, int right) {
        if(left >= right) return;

        int pivot = arr[(left + right) / 2];
        int l = left;
        int r = right;

        while(l <= r) {
            while(arr[l] < pivot) l++;
            while(arr[r] > pivot) r--;

            if(l <= r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;

                l++;
                r--;
            }
        }

        quick(left, r);
        quick(l, right);
    }
}
