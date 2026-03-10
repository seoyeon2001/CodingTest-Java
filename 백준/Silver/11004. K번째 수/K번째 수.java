import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int k;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

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

        if(k-1 <= r) sort(left, r);
        else if(k-1 >= l) sort(l, right);
        else return;
    }
}
