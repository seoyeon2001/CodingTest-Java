import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] temp;

    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        temp = new int[n];
        mergeSort(0, n-1);

        System.out.println(answer);
    }

    static void mergeSort(int left, int right) {
        if(left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid+1, right);

        for(int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int k = left;
        int idx1 = left;
        int idx2 = mid+1;

        while(idx1 <= mid && idx2 <= right) {
            if(temp[idx1] <= temp[idx2]) {
                arr[k] = temp[idx1];
                idx1++;
                k++;
            } else {
                arr[k] = temp[idx2];
                idx2++;
                k++;
                answer += idx2 - k;
            }
        }

        while(idx1 <= mid) {
            arr[k] = temp[idx1];
            idx1++;
            k++;
        }

        while(idx2 <= right) {
            arr[k] = temp[idx2];
            idx2++;
            k++;
        }
    }
}
