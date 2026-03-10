import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        temp = new int[n];
        mergeSort(0, n-1);

        // 출력
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    // 병합 정렬 O(nlogn)
    static void mergeSort(int left, int right) {
        if(left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left, mid, right);
    }

    static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while(l <= mid && r <= right) {
            if(arr[l] <= arr[r]) {
                temp[idx++] = arr[l++];
            } else {
                temp[idx++] = arr[r++];
            }
        }

        while(l <= mid) {
            temp[idx++] = arr[l++];
        }

        while(r <= right) {
            temp[idx++] = arr[r++];
        }

        for(int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
