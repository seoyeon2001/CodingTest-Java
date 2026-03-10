import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // quick sorting
        sort(0, n-1);

        System.out.println(arr[k-1]);
    }

    static void sort(int left, int right) {
        if(left >= right) return;

        int pivoit = arr[(left + right) / 2];
        int l = left;
        int r = right;

        while(l <= r) {
            while(arr[l] < pivoit) l++;
            while(arr[r] > pivoit) r--;

            if(l <= r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;

                l++;
                r--;
            }
        }

        sort(left, r);
        sort(l, right);
    }
}
