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
//        quickSortV1(0, n-1);
//        quickSortV2(0, n-1);

        Arrays.sort(arr);
        System.out.println(arr[k-1]);
    }

    static void quickSortV2(int left, int right) {
        if(left < right) {
            int pivotIdx = partition(left, right);

            if(pivotIdx == k-1) return;
            else if(k-1 < pivotIdx) {
                quickSortV2(left, pivotIdx-1);
            } else {
                quickSortV2(pivotIdx+1, right);
            }
        }
    }

    static int partition(int left, int right) {
        int mid = (left + right) / 2;
        swap(left, mid);
        int pivot = arr[left];
        int i = left+1, j = right;
        while(i <= j) {
            while(i <= right && arr[i] < pivot) i++;
            while(j >= left + 1 && arr[j] > pivot) j--;

            if(i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        arr[left] = arr[j];
        arr[j] = pivot;

        return j;
    }

    static void quickSortV1(int left, int right) {
        if(left >= right) return;

        int pivot = arr[(left + right) / 2];
        int l = left;
        int r = right;

        while(l <= r) {
            while(arr[l] < pivot) l++;
            while(arr[r] > pivot) r--;

            if(l <= r) {
                swap(l, r);
                l++;
                r--;
            }
        }

        if(k-1 <= r) quickSortV1(left, r); // pivot보다 작거나 같은 값들
        else if(k-1 >= l) quickSortV1(l, right); // pivot보다 크거나 같은 값들
        else return;
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
